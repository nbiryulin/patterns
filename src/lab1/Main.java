package lab1;

import java.io.IOException;
import java.util.Properties;
import lab1.exceptions.DuplicateModelNameException;
import lab1.exceptions.NoSuchModelNameException;
import lab1.model.Car;
import lab1.model.Moto;
import lab1.model.Transport;
import lab1.service.MotoFactory;
import lab1.service.PropReadSingleton;
import lab1.utils.Utils;

public class Main {

  public static void main(String[] args)
      throws IOException, DuplicateModelNameException, NoSuchModelNameException {

   // task1();
  //  task2();
    task3();

  }


  private static void task1() throws IOException {
    Properties properties = PropReadSingleton.getInstance();
    System.out.println(properties.get("foo.bar"));
    System.out.println(properties.get("bar.foo"));
  }

  private static void task2() {
    Transport transport = Utils.createInstance("name", 2);
    System.out.println(transport.getClass());

    Utils.setTransportFactory(new MotoFactory());
    Transport newTransport = Utils.createInstance("name", 3);
    System.out.println(newTransport.getClass());

  }


  private static void task3() throws DuplicateModelNameException, NoSuchModelNameException {
    Moto moto = new Moto("mark", 3);
    System.out.println(moto.getMark());
    Moto newMoto = moto.clone();
    newMoto.setModelName("model.Moto 1", "ghjghjghg");
    newMoto.setModelName("model.Moto 2", "ghjghjghgfff");

    System.out.println(moto.getMark());


    //System.out.println(newMoto.getHead() == moto.getHead());
    System.out.println(moto.getModelsMap());

    System.out.println("Moto clone :");
    System.out.println(newMoto.getModelsMap());
    System.out.println(newMoto.getMark());
    //Car car = Utils.generateCar();
    //System.out.println(car.getMark());
    //Car newCar = car.clone();
    //System.out.println(car.getModels() == newCar.getModels());


    /**
        - почему клон. а не конструктор при клонировании
     **/
  }
}
