package interview;

// 2:
//  1. 1 step + 1 step
//  2. 2 steps

// 3:
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step
public class ClimbingStairs {

    public static void main(String[] args) {
        int input = 38;
        int answer = climbStairsExponentialComplexity(input);
        System.out.println("Exponential Complexity O(2^n) Answer: " + answer);
        answer = climbStairsLinearComplexity(input);
        System.out.println("Linear Complexity O(n) Answer: " + answer);
    }

    // Time Complexity: O(2^n) экспоненциальная
    // Space Complexity: O(n)
    public static int climbStairsExponentialComplexity(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairsExponentialComplexity(n - 1) + climbStairsExponentialComplexity(n - 2);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int climbStairsLinearComplexity(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }


}
