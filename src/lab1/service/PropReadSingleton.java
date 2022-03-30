package lab1.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropReadSingleton {

  private static Properties properties;

  private PropReadSingleton() {
  }

  public static synchronized Properties getInstance() throws IOException {
    if (properties == null) {
      properties = new Properties();
      properties.load(new FileReader("/Users/nbiryulin/IdeaProjects/patterns/src/lab1/resources/config.properties"));
    }
    return properties;
  }

}
