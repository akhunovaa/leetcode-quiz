package interview.array;

import java.util.*;

/**
 * <b>3Sum</b>
 * <p/>
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * <p/>
 * <b>Example 1:</b>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * <p/>
 <b>Example 2:</b>
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * <p/>
 <b>Example 3:</b>
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> answer = threeSum(nums);
        System.out.println("Answer: " + answer);
    }

    // Binary Search
    // Time: O(N * logN + N * N * logN)
    // Space: O(LogN)
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; ) {
            for (int j = i + 1; j < nums.length && nums[i] + nums[j] <= 0; ) {
                int value = 0 - nums[i] - nums[j];
                if (value < 0) {
                    return new ArrayList<>(resultSet);
                }
                int idx = Arrays.binarySearch(nums, j + 1, nums.length, value);
                if (idx >= 0) {
                    resultSet.add(Arrays.asList(nums[i], nums[j], value));
                }
                j++;
                while (j < nums.length && nums[j] == nums[j - 1]) {
                    j++;
                }
            }
            i++;
            while (i < nums.length - 2 && nums[i] == nums[i - 1]) {
                i++;
            }
        }
        return new ArrayList<>(resultSet);
    }

}
