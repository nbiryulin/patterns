package lab1.visitor;

import lab1.model.Car;
import lab1.model.Moto;

public class PrintVisitor implements Visitor {
    @Override
    public void visit(Car car) {
        car.getModelsMap().forEach((k,v) -> System.out.print(k + " " + v + ";"));
    }

    @Override
    public void visit(Moto moto) {
        moto.getModelsMap().forEach((k,v) -> System.out.print(k + " " + v + ";\n"));
    }

}
