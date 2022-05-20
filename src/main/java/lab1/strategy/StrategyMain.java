package lab1.strategy;

public class StrategyMain {
    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.out.println("Неверное число параметров");
            return;
        }

        StrategyContext strategyManager = new StrategyContext();

        strategyManager.setStrategy(new DomStrategy());
        strategyManager.executeStrategy(args[0], args[1]);

        strategyManager.setStrategy(new SaxStrategy());
        strategyManager.executeStrategy(args[0], args[2]);
    }
}
