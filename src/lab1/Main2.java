package lab1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import lab1.adapter.Adapter;
import lab1.adapter.AdapterImpl;

public class Main2 {

  public static void main(String[] args) {
    Adapter adapter = new AdapterImpl();
    try {
      adapter.charsToBytes(new String[]{"1", "2"}, new FileOutputStream("file"));
      BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("file")));
      while (br.ready()) System.out.println(br.readLine());
      br.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
