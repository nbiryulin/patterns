package lab1.dao;

import lab1.exceptions.DuplicateModelNameException;
import lab1.model.Transport;

import java.io.*;

public class ObjectDAO implements DAO {

    @Override
    public void writeTransport(Transport transport, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(transport);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Transport readTransport(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            Transport transport = (Transport) inputStream.readObject();
            inputStream.close();
            return transport;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
