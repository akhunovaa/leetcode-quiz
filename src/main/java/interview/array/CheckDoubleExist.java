package interview.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Check If N and Its Double Exist
 * Given an array arr of integers, check if there exist two indices i and j such that :
 *<p/>
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 *<p/>
 * Example 1:
 * Input: arr = [10,2,5,3]
 * Output: true
 * Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
 *<p/>
 * Example 2:
 * Input: arr = [3,1,7,11]
 * Output: false
 * Explanation: There is no i and j that satisfy the conditions.
 */
public class CheckDoubleExist {

    public static void main(String[] args) {
        int[] nums = {10, 2, 5, 3};
        boolean answer = checkIfExist(nums);
        System.out.println("Answer: " + answer);
    }

    // Time complexity : O(n * logn) квази-линейная т.к. set.contains() может быть O(logn)
    // Space complexity : O(n)
    public static boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(i * 2) || (i % 2 == 0 && set.contains(i / 2))) {
                return true;
            }

            set.add(i);
        }
        return false;
    }
}
