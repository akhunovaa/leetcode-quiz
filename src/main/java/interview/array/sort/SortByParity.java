package interview.array.sort;

import java.util.Arrays;

/**
 * Sort Array By Parity
 * <p/>
 * Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
 * Return any array that satisfies this condition.
 * <p/>
 * Example 1:
 * Input: nums = [3,1,2,4]
 * Output: [2,4,3,1]
 * Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * <p/>
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 */
public class SortByParity {

    public static void main(String[] args) {
        int[] nums = {2, 3, 2, 5, 9, 4};
        int[] answer = sortArrayByParity(nums);
        System.out.println("Answer: " + Arrays.toString(answer));
    }

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static int[] sortArrayByParity(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] % 2 > nums[end] % 2) {
                nums[start] ^= nums[end];
                nums[end] ^= nums[start];
                nums[start] ^= nums[end];
            }
            if (nums[start] % 2 == 0) {
                start++;
            }
            if (nums[end] % 2 == 1) {
                end--;
            }
        }
        return nums;
    }
}
