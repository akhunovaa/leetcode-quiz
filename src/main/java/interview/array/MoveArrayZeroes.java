package interview.array;

import java.util.Arrays;

/**
 * Move Zeroes
 * <p/>
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 * <p/>
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * <p/>
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 */
public class MoveArrayZeroes {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println("Answer: " + Arrays.toString(nums));
    }

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static void moveZeroes(int[] nums) {
        int lastNonZeroFoundAt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
//
//    /*
//    Перенести нули в конец массива, сохранив порядок остальных элементов
//    [1, 0, 8, 9] -> [1, 8, 9, 0]
//    */
//// Time: O(n)
//// Space: O(1)
//    public void moveZeros(int[] nums) {
//        int moveZeroLastIdx = 0;
//
//        for(int i = 0; i < nums.length; i++) {
//            if(nums[i] != 0) {
//                nums[moveZeroLastIdx++] = nums[i];
//            }
//        }
//
//        for(int i = moveZeroLastIdx; i < nums.length; i++) {
//            nums[i] = 0;
//        }
//
//
//    }
//
//
//class Point {
//    int x, y;
//}
//
//    // O(n log n)
//    public boolean hasVerticalSymLine(int[][] points) {
//
//
//
//        int[] xLine = new int[points.length];
//        int[] yLine = new int[points.length];
//
//        for(int i = 0; i < points.length; i++) {
//            xLine[i] = points[i].x;
//            yLine[i] = points[i].y;
//        }
//
//        Arrays.sort(xLine);
//        Arrays.sort(yLine);
//
//        int start = 0;
//        int end = points.length - 1;
//        // {2, 2}, {4, 4}, {6, 4}, {8, 2}
//        // x + x
//        while(start < end) {
//             Point st = points[start++];
//             Point stNext = points[start];
//
//
//            Point ed = points[end--];
//            Point edPre = points[end];
//
//            int divS = stNext.x - st.x;
//            int divE = edPre.x - ed.x;
//
//            int divYS = stNext.y - st.y;
//            int divYE = edPre.y - ed.y;
//
//            // x & y
//            if(divS != divE || divYS != divYE) {
//                return false;
//            } else {
//                start++;
//                end--;
//            }
//
//        }
//
//        return true;
//    }
//|
//        |
//        | 4   *   *   *   *
//        |
//        | 2   *           *
//        |     2  4    8   10
//        |
//        __________________
//
//        |
//        |
//        |
//        |
//        |     *    |   *
//        |     2   11   20
//        |
//        __________________
//
//
//
//
//        Y
//        *         *
//        *         *
//        *         *
//        *         *
//        *         *
//        *         *
//        *         *
//        *         *
//        *         *
//        *         *
//        * * * * * * * * * * * X



