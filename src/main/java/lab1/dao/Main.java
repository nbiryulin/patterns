package lab1.dao;

import lab1.exceptions.DuplicateModelNameException;
import lab1.model.Transport;
import lab1.utils.Utils;

public class Main {

    public static void main(String[] args) throws DuplicateModelNameException {
//        Transport transport = Utils.generateCar();
        Transport transport = Utils.generateMoto();

        ObjectDAO objectDAO = new ObjectDAO();
        TextDAO textDAO = new TextDAO();

        writeObject(transport, objectDAO, "/Users/nbiryulin/Desktop/patterns/obj");
        writeObject(transport, textDAO, "/Users/nbiryulin/Desktop/patterns/text");

        readObject(objectDAO, "/Users/nbiryulin/Desktop/patterns/obj");
        readObject(textDAO, "/Users/nbiryulin/Desktop/patterns/text");

    }

    private static void readObject(DAO dao, String path) {
        Transport transport = dao.readTransport(path);
        Utils.printNames(transport);
        Utils.printPrices(transport);
    }

    private static void writeObject(Transport transport, DAO dao, String path) {
        dao.writeTransport(transport, path);
    }
}
