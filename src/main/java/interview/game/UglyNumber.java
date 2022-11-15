package interview.game;

/**
 * <b>Ugly Number</b>
 * <p></p>
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 * Given an integer n, return true if n is an ugly number.
 * <p></p>
 * <b>Example 1:</b>
 * Input: n = 6
 * Output: true
 * Explanation: 6 = 2 × 3
 * <p></p>
 * <b>Example 2:</b>
 * Input: n = 1
 * Output: true
 * Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 * <p></p>
 * <b>Example 3:</b>
 * Input: n = 14
 * Output: false
 * Explanation: 14 is not ugly since it includes the prime factor 7.
 */
public class UglyNumber {

    public static void main(String[] args) {
        int input = 14;
        boolean answer = isUgly(input);
        System.out.println("Answer: " + answer);
    }

    // Time complexity: O(log(N))
    // Space complexity: O(1)
    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        for (int factor : new int[] { 2, 3, 5 }) {
            n = keepDividingWhenDivisible(n, factor);
        }
        return n == 1;
    }

    private static int keepDividingWhenDivisible(int dividend, int divisor) {
        while (dividend % divisor == 0) {
            dividend /= divisor;
        }
        return dividend;
    }
}
