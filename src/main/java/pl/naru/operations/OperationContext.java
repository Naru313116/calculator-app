package pl.naru.operations;

public class OperationContext {
    private OperationStrategy strategy;

    public void setStrategy(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    public int operate(int value, int secondValue) {
        return strategy.calculate(value, secondValue);
    }

}
