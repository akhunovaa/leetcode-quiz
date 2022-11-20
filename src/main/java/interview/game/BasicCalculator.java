package interview.game;

import java.util.Stack;

/**
 * <b>Basic Calculator</b>
 * <p></p>
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it,
 * and return the result of the evaluation.
 * <p></p>
 * <b>Note:</b> You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 * <p></p>
 * <b>Example 1:</b>
 * Input: s = "1 + 1"
 * Output: 2
 * <p></p>
 * <b>Example 2:</b>
 * Input: s = " 2-1 + 2 "
 * Output: 3
 * <p></p>
 * <b>Example 3:</b>
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 */
public class BasicCalculator {

    public static void main(String[] args) {
        String target = "(1+(4+5+2)-3)+(6+8)";
        int answer = calculate(target);
        System.out.println("Answer: " + answer);
    }

    public static int calculate(String s) {
        int len = s.length(), sign = 1, result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                result += sum * sign;
            } else if (s.charAt(i) == '+')
                sign = 1;
            else if (s.charAt(i) == '-')
                sign = -1;
            else if (s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                result = result * stack.pop() + stack.pop();
            }
        }
        return result;
    }
}
