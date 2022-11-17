package interview.array;

/**
 * <b>Maximum Subarray</b>
 * <p></p>
 * Given an integer array nums, find the subarray which has the largest sum and return its sum.
 * <p></p>
 * <b>Example 1:</b>
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * <p></p>
 * <b>Example 2:</b>
 * Input: nums = [1]
 * Output: 1
 * <p></p>
 * <b>Example 3:</b>
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int answer = maxSubArray(nums);
        System.out.println("Answer: " + answer);
    }

    public static int maxSubArray(int[] nums) {

        int maxSoFar = nums[0], maxEndingHere = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
