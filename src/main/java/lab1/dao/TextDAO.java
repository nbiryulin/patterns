package lab1.dao;

import lab1.exceptions.DuplicateModelNameException;
import lab1.model.Transport;
import lab1.utils.Utils;

import java.io.*;

public class TextDAO implements DAO {

    @Override
    public void writeTransport(Transport transport, String fileName) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(fileName))) {
            printWriter.println(transport.getMark());
            printWriter.println(transport.getModelsLength());
            transport.getModelsMap().forEach((k,v)->{
                printWriter.println(k);
                printWriter.println(v);
            });
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Transport readTransport(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String mark = bufferedReader.readLine();
            int len = Integer.parseInt(bufferedReader.readLine());
            double price;
            String model;
            Transport t = Utils.createInstance(mark, 0);
            for (int i = 0; i < len; i++) {
                model = bufferedReader.readLine();
                price = Double.parseDouble(bufferedReader.readLine());
                if (t != null) {
                    t.addModel(model, price);
                }
            }
            return t;
        } catch (IOException | DuplicateModelNameException e) {
            e.printStackTrace();
        }
        return null;
    }
}
