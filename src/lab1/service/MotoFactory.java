package lab1.service;

import lab1.model.Moto;
import lab1.model.Transport;

public class MotoFactory implements TransportFactory {

  @Override
  public Transport createTransport(String mark, int size) {
    return new Moto(mark, size);
  }
}
