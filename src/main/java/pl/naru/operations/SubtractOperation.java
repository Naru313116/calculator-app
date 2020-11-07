package pl.naru.operations;

public class SubtractOperation implements OperationStrategy {
    @Override
    public int calculate(int value, int secondValue) {
        return value - secondValue;
    }
}
