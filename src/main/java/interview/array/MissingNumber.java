package interview.array;

/**
 * <b>Missing Number</b>
 * <p></p>
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 * <p></p>
 * <b>Example 1</b>:
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
 * <p></p>
 * <b>Example 2</b>:
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
 * <p></p>
 * <b>Example 3</b>:
 * Input: nums = [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 */
public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        // int[] nums = {0, 1};
        // int[] nums = {3, 0, 1};
        int answer = missingNumber(nums);
        System.out.println("Answer: " + answer);
    }

    public static int missingNumber(int[] nums) {
        int ans = nums.length;
        for (int i = 0; i < nums.length; i++) {
            // XOR of [0,n] is 0^1^2^3^4^5^6^7
            // XOR of input is 0^1^2^3^4^5^7
            // ans = (0^1^2^3^4^5^7) ^(0^1^2^3^4^5^6^7) = 0^0^1^1^2^2^3^3^4^4^5^5^6^7^7 = 6
            // вычленяем то число, которого нет в массиве, а в итерации оно учавствует т.к. i++
            // и в таком случае аждому числу найдется пара, а отсутствующему в массиве пара не найдется
            // такое число и будет отсутствующим в массиве
            ans = ans ^ i ^ nums[i];
        }
        return ans;
    }
}
