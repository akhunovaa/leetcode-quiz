package calculator;

import calculator.core.Number;
import calculator.core.*;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private String operation;
    private Number operand1;
    private Number operand2;
    private final Map<String, Operation> operationMap = new HashMap<>();

    {
        operationMap.put("+", new Addition());
        operationMap.put("-", new Subtraction());
        operationMap.put("*", new Multiplication());
        operationMap.put("/", new Division());
    }

    public Calculator() {
    }

    public Calculator(calculator.core.Number operand1, calculator.core.Number operand2, String operation) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setOperand1(Number operand1) {
        this.operand1 = operand1;
    }

    public void setOperand2(Number operand2) {
        this.operand2 = operand2;
    }

    public String makeCalculation() {
        Operation operationMapValue = operationMap.get(operation);
        if (operand1 instanceof ArabianNumber && operand2 instanceof ArabianNumber) {
            return makeArabianCalculation(operationMapValue).getStringValue();
        } else {
            return makeRomanCalculation(operationMapValue).getStringValue();
        }
    }

    private calculator.core.Number makeArabianCalculation(Operation operation) {
        int answer = operation.calculateResult(operand1.getIntValue(), operand2.getIntValue());
        return new ArabianNumber(String.valueOf(answer));
    }

    private Number makeRomanCalculation(Operation operation) {
        int answer = operation.calculateResult(operand1.getIntValue(), operand2.getIntValue());
        return new RomanNumber(String.valueOf(answer));
    }
}
