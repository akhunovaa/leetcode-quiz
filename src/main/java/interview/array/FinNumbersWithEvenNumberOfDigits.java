package interview.array;

public class FinNumbersWithEvenNumberOfDigits {

    public static void main(String[] args) {
        int[] input = {580, 317, 640, 957, 718, 764}; // [580,317,640,957,718,764]
        //int[] input = {12, 345, 2, 6, 7896};// [580,317,640,957,718,764]
        int answer = findNumbers(input);
        System.out.println("Answer: " + answer);
    }

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static int findNumbers(int[] nums) {
        int c = 0;
        for (int i : nums) {
            if (digit(i)) {
                c++;
            }
        }
        return c;
    }

    public static boolean digit(int n) {
        int c = 0;
        while (n != 0) {
            c++;
            n /= 10;
        }
        return (c % 2 == 0);
    }
}
