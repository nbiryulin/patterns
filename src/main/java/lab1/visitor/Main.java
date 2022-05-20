package lab1.visitor;


import lab1.exceptions.DuplicateModelNameException;
import lab1.model.Transport;
import lab1.utils.Utils;

public class Main {
    public static void main(String[] args) throws DuplicateModelNameException {

        Transport car = Utils.generateCar();
        Transport moto = Utils.generateMoto();

        car.accept(new PrintVisitor());
        System.out.println("");
        moto.accept(new PrintVisitor());
    }
}
