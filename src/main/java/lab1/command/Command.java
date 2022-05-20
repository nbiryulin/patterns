package lab1.command;

import lab1.model.Car;

import java.io.Writer;
import java.util.Map;

public interface Command {
    void execute(Map<String, Double> models, Writer out);
}
