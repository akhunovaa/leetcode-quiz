package calculator;

import calculator.core.ArabianNumber;
import calculator.core.Number;
import calculator.core.RomanNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class CalculatorApplication {

    private static final String commandsLine = "Для выполнения операции + сложения, - вычитания, * умножения или / деления введите два числа по примеру '1 + 2', 'VI / III' :\n";
    private static boolean needQuit = false;
    private static String currentPrompt = null;


    public static void main(String[] args) {
        while (!needQuit) {
            sendCommand();
        }

    }

    private static void sendCommand() {
        String enteredConsoleData = promptString(commandsLine);
        if (enteredConsoleData == null) {
           return;
        }
        String operator;
        try {
            enteredConsoleData = enteredConsoleData.trim().replaceAll(" ", "");

            int indexOfOperator = indexOfOperator(enteredConsoleData);

            operator = enteredConsoleData.substring(indexOfOperator, indexOfOperator + 1);
            Number firstNumber;
            Number secondNumber;
            if (RomanNumber.isRomanNumber(enteredConsoleData.substring(0, indexOfOperator))) {
                firstNumber = new RomanNumber(enteredConsoleData.substring(0, indexOfOperator));
            } else {
                firstNumber = new ArabianNumber(enteredConsoleData.substring(0, indexOfOperator));
            }
            if (RomanNumber.isRomanNumber(enteredConsoleData.substring(indexOfOperator + 1))) {
                secondNumber = new RomanNumber(enteredConsoleData.substring(indexOfOperator + 1));
            } else {
                secondNumber = new ArabianNumber(enteredConsoleData.substring(indexOfOperator + 1));
            }
            validateNumsForOperate(firstNumber, secondNumber);

            Calculator calculator = new Calculator(firstNumber, secondNumber, operator);
            String answer = calculator.makeCalculation();
            print(answer);
        } catch (ArithmeticException ae) {
            print(ae.getMessage().replaceAll("/ by zero", "делить на ноль нельзя!"));
            needQuit = true;
        } catch (InputMismatchException e) {
            print(e.getMessage());
        }
    }

    private static String promptString(String prompt) {
        System.out.print(prompt);
        currentPrompt = prompt;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        try {
            str = reader.readLine();
        } catch (IOException e) {
            print(e.getMessage());
        }
        currentPrompt = null;
        return str;
    }


    private static void print(String str) {
        System.err.println(str);
        if (currentPrompt != null) {
            System.err.print(currentPrompt);
        }
    }

    private static int indexOfOperator(String str) {
        if (str.contains("-")) {
            return str.indexOf("-");
        } else if (str.contains("+")) {
            return str.indexOf("+");
        } else if (str.contains("*")) {
            return str.indexOf("*");
        } else if (str.contains("/")) {
            return str.indexOf("/");
        } else {
            throw new InputMismatchException("Нереально заслать калькулятору неизвестный ему знак оператора: " + str);
        }
    }

    public static void validateNumsForOperate(Number firstNumber, Number secondNumber) {
        boolean firstIsRoman = firstNumber instanceof RomanNumber;
        boolean secondIsRoman = secondNumber instanceof RomanNumber;
        if ((firstIsRoman && !secondIsRoman) || (!firstIsRoman && secondIsRoman)) {
            throw new ArithmeticException(String.format("Разрешены только однотипные числа! Оперировать разными типами чисел %s и %s запрещено! Калькулятор не поймет )", firstNumber.getStringValue(), secondNumber.getStringValue()));
        }
    }

}
