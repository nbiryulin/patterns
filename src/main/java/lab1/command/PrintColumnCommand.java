package lab1.command;

import lab1.utils.Utils;

import java.io.Writer;
import java.util.Map;

public class PrintColumnCommand implements Command{

    @Override
    public void execute(Map<String, Double> models, Writer out) {
        Utils.printColumn(models, out);
    }
}
