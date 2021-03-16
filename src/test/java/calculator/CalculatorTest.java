package calculator;

import calculator.core.ArabianNumber;
import calculator.core.RomanNumber;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void addsTwoArabianNumbers() {
        calculator.setOperand1(new ArabianNumber("6"));
        calculator.setOperand2(new ArabianNumber("2"));
        calculator.setOperation("+");
        assertEquals("8", calculator.makeCalculation());
    }

    @Test
    public void subtractsTwoArabianNumbers() {
        calculator.setOperand1(new ArabianNumber("10"));
        calculator.setOperand2(new ArabianNumber("3"));
        calculator.setOperation("-");
        assertEquals("7", calculator.makeCalculation());
    }

    @Test
    public void multipliesTwoArabianNumbers() {
        calculator.setOperand1(new ArabianNumber("2"));
        calculator.setOperand2(new ArabianNumber("2"));
        calculator.setOperation("*");
        assertEquals("4", calculator.makeCalculation());
    }

    @Test
    public void dividesTwoArabianNumbers() {
        calculator.setOperand1(new ArabianNumber("9"));
        calculator.setOperand2(new ArabianNumber("3"));
        calculator.setOperation("/");
        assertEquals("3", calculator.makeCalculation());
    }


    @Test
    public void addsTwoRomanNumbers() {
        calculator.setOperand1(new RomanNumber("III"));
        calculator.setOperand2(new RomanNumber("II"));
        calculator.setOperation("+");
        assertEquals("V", calculator.makeCalculation());
    }

    @Test
    public void subtractsTwoRomanNumbers() {
        calculator.setOperand1(new RomanNumber("VI"));
        calculator.setOperand2(new RomanNumber("II"));
        calculator.setOperation("-");
        assertEquals("IV", calculator.makeCalculation());
    }

    @Test
    public void multipliesTwoRomanNumbers() {
        calculator.setOperand1(new RomanNumber("V"));
        calculator.setOperand2(new RomanNumber("V"));
        calculator.setOperation("*");
        assertEquals("XXV", calculator.makeCalculation());
    }

    @Test
    public void dividesTwoRomanNumbers() {
        calculator.setOperand1(new RomanNumber("VIII"));
        calculator.setOperand2(new RomanNumber("II"));
        calculator.setOperation("/");
        assertEquals("IV", calculator.makeCalculation());
    }
}
