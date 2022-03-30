package lab1.decorator;

import java.util.Map;
import lab1.exceptions.DuplicateModelNameException;
import lab1.exceptions.ModelPriceOutOfBoundsException;
import lab1.exceptions.NoSuchModelNameException;
import lab1.model.Transport;

public class SynchronizedTransport implements Transport {

  private final Transport transport;

  public SynchronizedTransport(Transport transport) {
    this.transport = transport;
  }


  @Override
  public synchronized String[] getModelNames() {
    return transport.getModelNames();
  }

  @Override
  public synchronized double getPriceByName(String name) throws NoSuchModelNameException {
    return transport.getPriceByName(name);
  }

  @Override
  public synchronized void setPriceByName(String name, double price)
      throws NoSuchModelNameException, ModelPriceOutOfBoundsException {
    transport.setPriceByName(name, price);
  }

  @Override
  public synchronized double[] getPrices() {
    return transport.getPrices();
  }

  @Override
  public synchronized void addModel(String name, double price) throws DuplicateModelNameException {
    transport.addModel(name, price);
  }

  @Override
  public synchronized void deleteModel(String name, double price) throws NoSuchModelNameException {
    transport.deleteModel(name, price);
  }

  @Override
  public synchronized int getModelsLength() {
    return transport.getModelsLength();
  }

  @Override
  public synchronized String getMark() {
    return transport.getMark();
  }

  @Override
  public synchronized void setMark(String mark) {
    transport.setMark(mark);
  }

  @Override
  public synchronized void setModelName(String oldName, String newName)
      throws NoSuchModelNameException, DuplicateModelNameException {
    transport.setModelName(oldName, newName);
  }

  @Override
  public synchronized Map<String, Double> getModelsMap() {
    return transport.getModelsMap();
  }
}
