package interview.array;

/**
 * <b>Binary Search</b>
 * <p></p>
 * Given an array of integers nums which is sorted in ascending order,
 * and an integer target, write a function to search target in nums.
 * If target exists, then return its index. Otherwise, return -1.
 *
 * You must write an algorithm with <b>O(log n)</b> runtime complexity.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = -1;
        int answer = search(nums, target);
        System.out.println("Answer: " + answer);
    }

    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    public static int search(int[] nums, int target) {
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
        return -1;
    }
}
