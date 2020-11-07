package pl.naru.workers;

import pl.naru.operations.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class DataWorker {
    private final List<String> statement;
    private final OperationContext context = new OperationContext();

    public DataWorker(List<String> statement) {
        this.statement = statement;
    }

    public boolean isStatementValid() {
        Pattern pattern = Pattern.compile("^apply [0-9]+");
        return statement.get(statement.size()-1).matches((pattern.pattern()));
    }

    public int executeStatement() {
        int lastLinePosition = statement.size() - 1;
        int lastNumber = retrieveLastNumber(lastLinePosition);
        statement.remove(lastLinePosition);

        return disposeCalculation(lastNumber);

    }


    private int retrieveLastNumber(int lastLinePosition) {
        return Integer.parseInt(Objects.requireNonNull(Arrays.stream(statement
                .get(lastLinePosition)
                .split(" "))
                .reduce((first, second) -> second)
                .orElse(null)));
    }

    private int disposeCalculation(int initValue) {
        int sum = initValue;
        for (String line : statement) {
            sum = calculate(sum, line);
        }
        return sum;
    }

    private int calculate(int value, String line) {
        String[] splitLine = line.split(" ");
        String operation = splitLine[0];
        int secondValue = Integer.parseInt(splitLine[1]);

        switch (operation) {
            case "add" -> {
                context.setStrategy(new AddOperation());
                return context.operate(value, secondValue);
            }
            case "subtract" -> {
                context.setStrategy(new SubtractOperation());
                return context.operate(value, secondValue);
            }
            case "multiply" -> {
                context.setStrategy(new MultiplyOperation());
                return context.operate(value, secondValue);
            }
            case "divide" -> {
                context.setStrategy(new DivideOperation());
                return context.operate(value, secondValue);
            }
            case "power" -> {
                context.setStrategy(new PowerOperation());
                return context.operate(value, secondValue);
            }
            default -> throw new UnsupportedOperationException("Statement contains unsupported operation called: " + operation);
        }
    }
}
