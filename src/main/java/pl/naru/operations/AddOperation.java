package pl.naru.operations;

public class AddOperation implements OperationStrategy {
    @Override
    public int calculate(int value, int secondValue) {
        return value + secondValue;
    }
}
