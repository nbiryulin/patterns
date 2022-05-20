package lab1.adapter;

import java.io.IOException;
import java.io.OutputStream;

public interface Adapter {

  OutputStream charsToBytes(String[] strings, OutputStream outputStream) throws IOException;

}
