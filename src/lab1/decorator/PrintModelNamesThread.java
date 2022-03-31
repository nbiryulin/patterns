package lab1.decorator;

import lab1.exceptions.NoSuchModelNameException;
import lab1.model.Transport;

public class PrintModelNamesThread extends Thread {

    private final Transport transport;

    public PrintModelNamesThread(String name, Transport transport) {
        super(name);
        this.transport = transport;
    }

    public void run() {
        System.out.println(getName() + " " + transport.getModelsLength());
        try {
            transport.deleteModel("Model 0", 1.0);
        } catch (NoSuchModelNameException e) {
            return;
        }
        System.out.println(getName() + " " + transport.getModelsLength());
    }
}
