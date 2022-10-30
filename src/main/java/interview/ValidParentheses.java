package interview;


import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String input = "([";
        boolean answer = isValid(input);
        System.out.println("Answer: " + answer);
    }

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char element : chars) {
            if (element == '(' || element == '[' || element == '{') {
                stack.push(element);
                continue;
            } else if (stack.empty()) {
                return false;
            }
            char top = stack.pop();
            if (top == '(' && element != ')') {
                return false;
            } else if (top == '[' && element != ']') {
                return false;
            } else if (top == '{' && element != '}') {
                return false;
            }
        }
        return stack.empty();
    }
}
