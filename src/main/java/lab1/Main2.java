package lab1;

import java.io.*;

import lab1.adapter.Adapter;
import lab1.adapter.AdapterImpl;
import lab1.decorator.PrintModelNamesThread;
import lab1.exceptions.DuplicateModelNameException;
import lab1.model.Transport;
import lab1.utils.Utils;

public class Main2 {

  public static void main(String[] args) throws DuplicateModelNameException {
    //task1();
    task2();
  }

  private static void task1() {
    Adapter adapter = new AdapterImpl();
    try(OutputStream outputStream = adapter.charsToBytes(new String[]{"1", "2"}, new BufferedOutputStream(System.out))) {
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void task2() throws DuplicateModelNameException {
    Transport transport = Utils.synchronizedTransport(Utils.generateCar());
    for (int i = 0; i < 10; i++) {
      PrintModelNamesThread names = new PrintModelNamesThread("thread" + i , transport);
      names.start();
    }

  }
}
