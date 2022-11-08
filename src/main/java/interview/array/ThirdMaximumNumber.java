package interview.array;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * <b>Third Maximum Number</b>
 * <p/>
 * <i>Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.</i>
 * <p/>
 * <b>Example 1:</b>
 * Input: nums = [3,2,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2.
 * The third distinct maximum is 1.
 * <p/>
 * <b>Example 2:</b>
 * Input: nums = [1,2]
 * Output: 2
 * Explanation:
 * The first distinct maximum is 2.
 * The second distinct maximum is 1.
 * The third distinct maximum does not exist, so the maximum (2) is returned instead.
 * <p/>
 * <b>Example 3:</b>
 * Input: nums = [2,2,3,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2 (both 2's are counted together since they have the same value).
 * The third distinct maximum is 1.
 * <p/>
 * <b>Space complexity</b>: O(1)
 * <p/>
 * We don't use any additional space.
 * <p/>
 * <b>Note</b>: The built-in sort methods do use some additional space, you can tell this during the interview, but, the interviewer does not expect us to go into much detail about it, and it will be fine if we state the above space complexity analysis.
 */
public class ThirdMaximumNumber {

    public static void main(String[] args) {
        int[] input = {9, 5, 6, 1, 7, 3, 3, 2, 1};
        int answer = thirdMax(input);
        System.out.println("Answer: " + answer);
    }

    // Time complexity: O(N)
    // Space complexity: O(1)
    public static int thirdMax(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Set<Integer> taken = new HashSet<>();

        for (int index = 0; index < nums.length; ++index) {
            if (taken.contains(nums[index])) {
                continue;
            }
            if (minHeap.size() == 3) {
                if (minHeap.peek() < nums[index]) {
                    taken.remove(minHeap.poll());
                    minHeap.add(nums[index]);
                    taken.add(nums[index]);
                }
            } else {
                minHeap.add(nums[index]);
                taken.add(nums[index]);
            }
        }

        if (minHeap.size() == 1) {
            return minHeap.peek();
        } else if (minHeap.size() == 2) {
            int firstNum = minHeap.poll();
            return Math.max(firstNum, minHeap.peek());
        }

        return minHeap.peek();
    }

}
