package lab1.service;

import lab1.model.Car;
import lab1.model.Transport;

public class AutoFactory implements TransportFactory {

  @Override
  public Transport createTransport(String mark, int size) {
    return new Car(mark, size);
  }
}
