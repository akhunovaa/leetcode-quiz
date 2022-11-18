package interview.game;

/**
 * <b>Subtract the Product and Sum of Digits of an Integer</b>
 * <p></p>
 * Given an integer number n, return the difference between the product of its digits and the sum of its digits.
 * <p></p>
 * <b>Example 1:</b>
 * Input: n = 234
 * Output: 15
 * Explanation:
 * Product of digits = 2 * 3 * 4 = 24
 * Sum of digits = 2 + 3 + 4 = 9
 * Result = 24 - 9 = 15
 * <p></p>
 * <b>Example 2:</b>
 * Input: n = 4421
 * Output: 21
 * Explanation:
 * Product of digits = 4 * 4 * 2 * 1 = 32
 * Sum of digits = 4 + 4 + 2 + 1 = 11
 * Result = 32 - 11 = 21
 */
public class SubtractProductAndSum {

    public static void main(String[] args) {
        int n = 234;
        int answer = subtractProductAndSum(n);
        System.out.println("Answer: " + answer);
    }

    static int subtractProductAndSum(int n) {
        //making a copy of the input number
        int temp = n;
        int digit;

        int prod = 1;
        int sum = 0;

        while (temp > 0) {
            digit = temp % 10;
            prod *= digit;
            sum += digit;
            temp = temp / 10;
        }
        return prod - sum;
    }

}
