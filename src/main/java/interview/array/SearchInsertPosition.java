package interview.array;

/**
 * <b>Search Insert Position</b>
 * <p></p>
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with <b>O(log n)</b> runtime complexity.
 * <p></p>
 * <b>Example 1</b>:
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * <p></p>
 * <b>Example 2</b>:
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * <p></p>
 * <b>Example 3</b>:
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 4;
        int answer = searchInsert(nums, target);
        System.out.println("Answer: " + answer);
    }

    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else if (nums[start] == target) {
                return start;
            } else if (nums[end] == target) {
                return end;
            } else {
                return mid;
            }
        }
        return start;
    }
}
