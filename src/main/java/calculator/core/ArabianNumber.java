package calculator.core;

public class ArabianNumber extends Number {

    public ArabianNumber(String number) {
        super(number);
    }

    @Override
    public int getIntValue() {
        return Integer.parseInt(number);
    }

    @Override
    public String getStringValue() {
        return number;
    }

}
