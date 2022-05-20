package lab1.strategy;

public class StrategyContext {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(String inputFileName, String outputFileName) throws Exception {
        strategy.execute(inputFileName, outputFileName);
    }

}
