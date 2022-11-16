package interview.array;

import java.util.Arrays;

/**
 * <b>Rotate Array</b>
 * <p></p>
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * <p></p>
 * <b>Example 1:</b>
 * <b>Input:</b> nums = [1,2,3,4,5,6,7], k = 3
 * <b>Output:</b> [5,6,7,1,2,3,4]
 * <b>Explanation:</b>
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * <p></p>
 * <b>Example 2:</b>
 * <b>Input:</b> nums = [-1,-100,3,99], k = 2
 * <b>Output:</b> [3,99,-1,-100]
 * <b>Explanation:</b>
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
        System.out.println("Answer: " + Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        int start = 0; // start pointer
        k = k % nums.length; // middle pointer
        int end = nums.length - 1; // end pointer

        reverse(nums, start, end - k); //  first half of array for reverse {1, 2, 3, 4} => {4, 3, 2, 1}
        reverse(nums, nums.length - k, end); //  second half of array for reverse {5, 6, 7} => {7, 6, 5}
        reverse(nums, start, end); //  third step flip the entire array {4, 3, 2, 1, 7, 6, 5} => {5, 6, 7, 1, 2, 3, 4}
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            nums[start] ^= nums[end];
            nums[end] ^= nums[start];
            nums[start++] ^= nums[end--];
        }
    }

}
