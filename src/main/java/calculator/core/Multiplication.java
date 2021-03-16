package calculator.core;

public class Multiplication implements Operation {

    @Override
    public int calculateResult(int left, int right) {
        return left * right;
    }

}
