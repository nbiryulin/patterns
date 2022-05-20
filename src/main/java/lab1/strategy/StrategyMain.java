package lab1.strategy;

public class StrategyMain {
    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.out.println("Неверное число параметров");
            return;
        }

        StrategyContext context = new StrategyContext();

        context.setStrategy(new DomStrategy());
        context.executeStrategy(args[0], args[1]);

        context.setStrategy(new SaxStrategy());
        context.executeStrategy(args[0], args[2]);
    }
}
