package pl.naru.operations;

public class PowerOperation implements OperationStrategy {
    @Override
    public int calculate(int value, int secondValue) {
        return (int) Math.pow(value, secondValue);
    }
}
