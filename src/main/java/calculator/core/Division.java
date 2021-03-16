package calculator.core;

public class Division  implements Operation {
    @Override
    public int calculateResult(int left, int right) {
        return left / right;
    }
}
