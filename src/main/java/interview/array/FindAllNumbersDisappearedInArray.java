package interview.array;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Find All Numbers Disappeared in an Array</b>
 * <p/>
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
 * <p/>
 * <b>Example 1</b>:
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * <p/>
 * <b>Example 2</b>:
 * Input: nums = [1,1]
 * Output: [2]
 */
public class FindAllNumbersDisappearedInArray {

    public static void main(String[] args) {
        int[] input = {2, 2};
        List<Integer> answer = findDisappearedNumbers(input);
        System.out.println("Answer: " + answer);
    }

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i : nums) {
            int index = Math.abs(i);
            if (nums[index - 1] > 0) {
                nums[index - 1] *= -1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

}
