package lab1.model;

import lab1.exceptions.DuplicateModelNameException;
import lab1.utils.Utils;

import java.util.Iterator;

public class Main45 {

    public static void main(String[] args) throws Exception {
//        testIterator();
        testMemento();
    }

    private static void testIterator() throws DuplicateModelNameException {
        Car car = Utils.generateCar();

        Iterator<Car.Model> it = car.iterator();

        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    private static void testMemento() throws Exception {
        Car car = Utils.generateCar();
        Car.Memento memento = car.createMemento();
        car.setMemento(memento);

        car.setMark("New Mark");
        System.out.println(car.toString());

        System.out.println(car.restore());
    }
}
