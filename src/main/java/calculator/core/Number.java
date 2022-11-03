package calculator.core;

public abstract class Number {

    String number;

    public Number(String number) {
      this.number = number;
    }

    public abstract int getIntValue();

    public abstract String getStringValue();


}
