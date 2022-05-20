package lab1.chain;

import lab1.model.Transport;

public interface Handler {

    public void setNext(Handler chain);

    public void handle(Transport transport);

}
