package lab1;

import lab1.chain.Handler;
import lab1.chain.PrintColumnHandler;
import lab1.chain.PrintRowHandler;
import lab1.command.Command;
import lab1.command.PrintColumnCommand;
import lab1.command.PrintRowCommand;
import lab1.exceptions.DuplicateModelNameException;
import lab1.model.Car;
import lab1.model.Transport;
import lab1.utils.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class Main3 {

    public static void main(String[] args) throws DuplicateModelNameException {
     // testChain();
        testCommand();
    }

    private static void testChain() throws DuplicateModelNameException {
        Handler row = new PrintRowHandler();
        Handler column = new PrintColumnHandler();

        row.setNext(column);

        Transport transport = Utils.generateCar();

        row.handle(transport);
    }

    private static void testCommand() throws DuplicateModelNameException {
        Car transport = Utils.generateCar();

        Command row = new PrintRowCommand();
        Command column = new PrintColumnCommand();

        try (FileWriter fileWriter = new FileWriter(new File("commandRow.txt"))) {
            transport.setCommand(row);
            transport.print(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fileWriter = new FileWriter(new File("commandColumn.txt"))) {
            transport.setCommand(column);
            transport.print(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
