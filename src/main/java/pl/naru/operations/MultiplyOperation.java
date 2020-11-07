package pl.naru.operations;

public class MultiplyOperation implements OperationStrategy {
    @Override
    public int calculate(int value, int secondValue) {
        return value * secondValue;
    }
}
