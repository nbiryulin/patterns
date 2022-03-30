package lab1.adapter;

import java.io.IOException;
import java.io.OutputStream;

public interface Adapter {

  void charsToBytes(String[] strings, OutputStream outputStream) throws IOException;

}
