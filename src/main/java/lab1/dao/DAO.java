package lab1.dao;

import lab1.model.Transport;

public interface DAO {

    void writeTransport(Transport transport, String fileName);
    Transport readTransport(String fileName);

}
