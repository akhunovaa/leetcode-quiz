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
        int[] nums = {4000, 3000, 1000, 2000};
        int answer = maxSubArray(nums);
        System.out.println("Answer: " + answer);
        System.out.println(average(nums));
    }

    public static double average(int[] salary) {
        if (salary.length == 0) {
            return 0.00;
        }

        int min = salary[0];
        int max = salary[salary.length - 1];

        int totalSum = 0;

        for (int i = 0; i < salary.length; i++) {
            int curSalary = salary[i];
            totalSum += curSalary;
            if (curSalary < min) {
                min = curSalary;
            }
            if (curSalary > max) {
                max = curSalary;
            }
        }
        totalSum = totalSum - max - min;
        return (double) totalSum / (salary.length - 2);

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
