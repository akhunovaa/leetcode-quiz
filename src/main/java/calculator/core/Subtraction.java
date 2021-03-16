package calculator.core;

public class Subtraction implements Operation {

    @Override
    public int calculateResult(int left, int right) {
        return left - right;
    }
}
