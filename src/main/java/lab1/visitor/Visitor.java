package lab1.visitor;


import lab1.model.Car;
import lab1.model.Moto;

public interface Visitor {
    void visit(Car car);
    void visit(Moto moto);
}
