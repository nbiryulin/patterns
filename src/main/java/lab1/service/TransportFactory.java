package lab1.service;

import lab1.model.Transport;

public interface TransportFactory {

  public Transport createTransport(String mark, int size);

}
