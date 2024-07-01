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
        int[] nums = {1,3,5,6};
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

    public static int searchInsert2(int[] nums, int target) {
        // The left and right most indices in our range of consideration.
        int left = 0;
        int right = nums.length - 1;
        // Find the target or insertion index.
        while (left <= right) {
            // Get the middle index of our range.
            int middle = left + ((right - left) / 2);
            // Check if we've found our target, or shift our range.
            if (nums[middle] == target)
                return middle;
            else if (nums[middle] > target)
                right = middle - 1;
            else
                left = middle + 1;
        }
        // Left will be the index to insert at.
        return left;
    }
}
