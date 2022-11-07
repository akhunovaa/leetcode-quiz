package interview.array;

/**
 * Valid Mountain Array
 * <p/>
 * Given an array of integers arr, return true if and only if it is a valid mountain array.
 * <p/>
 * Example 1:
 * Input: arr = [2,1]
 * Output: false
 * <p/>
 * Example 2:
 * Input: arr = [3,5,5]
 * Output: false
 * <p/>
 * Example 3:
 * Input: arr = [0,3,2,1]
 * Output: true
 */
public class ValidMountainArray {

    public static void main(String[] args) {
        //int[] input = {3, 5, 5};
        int[] input = {0, 1, 2, 3, 4, 8, 9, 10, 11, 12, 11};
        boolean answer = validMountainArray(input);
        System.out.println("Answer: " + answer);
    }

    public static boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            if (arr[start + 1] > arr[start]) {
                start++;
            } else if (arr[end - 1] > arr[end]) {
                end--;
            } else {
                break;
            }
        }
        return start != 0 && end != arr.length - 1 && start == end;
    }
}
