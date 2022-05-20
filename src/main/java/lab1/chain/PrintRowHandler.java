package lab1.chain;

import lab1.model.Transport;
import lab1.utils.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PrintRowHandler implements Handler{

    private Handler next;

    @Override
    public void setNext(Handler chain) {
        this.next = chain; //null handle?
    }

    @Override
    public void handle(Transport transport) {
        if (transport.getModelsLength() <= 3) {

            try (FileWriter fileWriter = new FileWriter(new File("row.txt"))) {
                Utils.printRow(transport.getModelsMap(), fileWriter);
//                        .forEach((k, v) ->
//                                {
//                                    try {
//                                        fileWriter.write(k + " " + v + ";");
//                                    } catch (IOException e) {
//                                        e.printStackTrace();
//                                    }
//                                }
//                        );
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            if (next != null) {
                next.handle(transport);
            }
        }
    }
}