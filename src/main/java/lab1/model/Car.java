package lab1.model;

import lab1.command.Command;
import lab1.exceptions.DuplicateModelNameException;
import lab1.exceptions.ModelPriceOutOfBoundsException;
import lab1.exceptions.NoSuchModelNameException;
import lab1.visitor.Visitor;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Car implements Transport, Serializable, Cloneable {

    private String mark;
    private Model[] models;
    private Command command;
    private Memento memento;


    private static final long serialVersionUID = 1L;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void print(Writer writer) {
        command.execute(getModelsMap(), writer);
    }

    @Override
    public String toString() {
        return "Car{" +
                "mark='" + mark + '\'' +
                ", models=" + Arrays.toString(models) +
                '}';
    }

    @Override
    public Car clone() {
        try {
            Car newMoto = (Car) super.clone();
            Model[] newModels = new Model[models.length];
            for (int i = 0; i < models.length; i++) {
                newModels[i] = models[i].clone();
            }
            newMoto.setModels(newModels);
            return newMoto;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public Car() {
    }

    public Car(String mark, int count) {
        this.mark = mark;
        this.models = new Model[count];
        for (int i = 0; i < count; i++) {
            this.models[i] = new Model("model" + i, i);
        }
    }


    public void setModels(Model[] models) {
        this.models = models;
    }

    public Model[] getModels() {
        return models;
    }

    public String[] getModelNames() {
        return Arrays
                .stream(models)
                .parallel()
                .map(Model::getName)
                .toArray(String[]::new);
    }

    public double getPriceByName(String name) throws NoSuchModelNameException {
        Map<String, Double> map = getModelsMap();
        if (!map.containsKey(name)) {
            throw new NoSuchModelNameException();
        }
        return map.get(name);
    }

    public void setPriceByName(String name, double price) throws NoSuchModelNameException {
        Map<String, Double> map = getModelsMap();
        if (!map.containsKey(name)) {
            throw new NoSuchModelNameException();
        } else if (price < 0) {
            throw new ModelPriceOutOfBoundsException();
        }
        map.put(name, price);
        models = map.entrySet().stream().map(v -> new Model(v.getKey(), v.getValue())).toArray(Model[]::new);
    }

    public double[] getPrices() {
        return Arrays.stream(models).mapToDouble(Model::getPrice).toArray();
    }

    public void addModel(String name, double price) throws DuplicateModelNameException {
        Map<String, Double> map = getModelsMap();
        if (map.containsKey(name)) {
            throw new DuplicateModelNameException();
        } else if (price < 0) {
            throw new ModelPriceOutOfBoundsException();
        }
        int size = getModelsLength() + 1;
        if (models != null) {
            Model[] array = Arrays.copyOf(models, size);
            array[getModelsLength()] = new Model(name, price);
            models = array;
        } else {
            models = new Model[]{new Model(name, price)};
        }

    }

    public Map<String, Double> getModelsMap() {
        if (getModelsLength() == 0) {
            return new HashMap<>();
        }
        return Arrays.stream(models)
                .collect(
                        Collectors.toMap(
                                Model::getName,
                                Model::getPrice
                        )
                );
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void deleteModel(String name, double price) throws NoSuchModelNameException {
        int position = -1;
        Model model = new Model(name, price);
        for (int i = 0; i < getModelsLength(); i++) {
            if (models[i].equals(model)) {
                position = i;
            }
        }
        if (position == -1) {
            throw new NoSuchModelNameException();
        }
        System.arraycopy(models, position + 1, models, position, models.length - position - 1);
        models = Arrays.copyOf(models, models.length - 1);
    }

    public int getModelsLength() {
        if (models == null) {
            return 0;
        } else {
            return (int) Arrays.stream(models).filter(Objects::nonNull).count();
        }
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public void setModelName(String oldName, String newName) throws NoSuchModelNameException, DuplicateModelNameException {
        Map<String, Double> map = getModelsMap();
        if (map.containsKey(newName)) {
            throw new DuplicateModelNameException();
        } else if (!map.containsKey(oldName)) {
            throw new NoSuchModelNameException();
        }
        Double price = getModelsMap().get(oldName);
        map.remove(oldName);
        map.put(newName, price);
        models = map.entrySet().stream().map(v -> new Model(v.getKey(), v.getValue())).toArray(Model[]::new);
    }

    private class CarIterator implements Iterator<Model> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < models.length;
        }

        @Override
        public Model next() {
            return models[currentIndex++];
        }

    }

    public Iterator<Model> iterator() {
        return new CarIterator();
    }

    public Memento createMemento() {
        return new Memento(this);
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }

    public Car restore() throws Exception {
        return this.memento.getAuto();
    }

    public static class Memento {
        private static byte[] carBytes;

        public Memento(Car car) {
            setAuto(car);
        }

        public static void setAuto(Car car) {
            try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
                try (ObjectOutputStream out = new ObjectOutputStream(byteArrayOutputStream)) {
                    out.writeObject(car);
                    out.flush();
                }

                byteArrayOutputStream.flush();
                carBytes = byteArrayOutputStream.toByteArray();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

        public static Car getAuto() throws Exception {
            if (carBytes == null) {
                throw new Exception("");
            }

            try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(carBytes)) {
                try (ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
                    return (Car) objectInputStream.readObject();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            return null;
        }
    }

    private void setNewCar(Car newCar) {
        this.mark = newCar.mark;
        this.models = newCar.models;
    }

    static class Model implements Serializable, Cloneable {

        @Override
        public Model clone() {
            try {
                return (Model) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }

        @Override
        public String toString() {
            return "Model{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }

        private String name;

        public double getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        private double price;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Model model = (Model) o;
            return price == model.price && name.equals(model.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, price);
        }

        public Model(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }
}
