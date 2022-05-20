package lab1.chain;

import lab1.model.Transport;
import lab1.utils.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PrintColumnHandler implements Handler {

    private Handler next;

    @Override
    public void setNext(Handler chain) {
        this.next = chain; //null handle?
    }

    @Override
    public void handle(Transport transport) {
        if (transport.getModelsLength() > 3) {

            try (FileWriter fileWriter = new FileWriter(new File("column.txt"))) {
                Utils.printColumn(transport.getModelsMap(), fileWriter);
//                        .forEach((k, v) ->
//                                {
//                                    try {
//                                        fileWriter.write(k + " " + v + ";\n");
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
