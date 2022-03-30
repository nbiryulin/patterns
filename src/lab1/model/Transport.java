package lab1.model;

import lab1.exceptions.DuplicateModelNameException;
import lab1.exceptions.ModelPriceOutOfBoundsException;
import lab1.exceptions.NoSuchModelNameException;
import java.util.Map;

public interface Transport {

    public String[] getModelNames();

    public double getPriceByName(String name) throws NoSuchModelNameException;

    public void setPriceByName(String name, double price) throws NoSuchModelNameException, ModelPriceOutOfBoundsException;

    public double[] getPrices();

    public void addModel(String name, double price) throws DuplicateModelNameException;

    public void deleteModel(String name, double price) throws NoSuchModelNameException;

    public int getModelsLength();

    public String getMark();

    public void setMark(String mark);

    public void setModelName(String oldName, String newName) throws NoSuchModelNameException, DuplicateModelNameException;

    public Map<String, Double> getModelsMap();
}
