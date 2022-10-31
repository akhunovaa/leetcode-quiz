package interview;

public class AddDigits {

    public static void main(String[] args) {
        int input =  38;
        int answer = addDigits(input);
        System.out.println("Answer: " + answer);
    }

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public static int addDigits(int num) {
        return num == 0 ? 0 : 1 + (num - 1) % 9;
    }
}
