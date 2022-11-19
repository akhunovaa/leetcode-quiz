package interview.array;

import java.util.Arrays;

/**
 * <b>Largest Perimeter Triangle</b>
 * <p></p>
 * Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed
 * from three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0.
 * <p></p>
 * <b>Example 1</b>:
 * Input: nums = [2,1,2]
 * Output: 5
 * <p></p>
 * <b>Example 2</b>:
 * Input: nums = [1,2,1]
 * Output: 0
 */
public class LargestPerimeterTriangle {

    public static void main(String[] args) {
        int[] nums = {2, 1, 2};
        int answer = largestPerimeter(nums);
        System.out.println("Answer: " + answer);
    }

    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 3; i >= 0; --i)
            if (nums[i] + nums[i + 1] > nums[i + 2]) {
                return nums[i] + nums[i + 1] + nums[i + 2];
            }
        return 0;
    }
}
