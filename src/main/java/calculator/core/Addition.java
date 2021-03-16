package calculator.core;

public class Addition implements Operation {
    @Override
    public int calculateResult(int operand1, int operand2) {
        return operand1 + operand2;
    }
}
