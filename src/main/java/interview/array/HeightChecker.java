package interview.array;

import java.util.Arrays;

/**
 * Height Checker  <p/>
 * A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in non-decreasing order by height. Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.
 *
 * You are given an integer array heights representing the current order that the students are standing in. Each heights[i] is the height of the ith student in line (0-indexed).
 * Return the number of indices where heights[i] != expected[i].
 *<p/>
 * Example 1:
 * Input: heights = [1,1,4,2,1,3]
 * Output: 3
 * Explanation:
 * heights:  [1,1,4,2,1,3]
 * expected: [1,1,1,2,3,4]
 * Indices 2, 4, and 5 do not match.
 *<p/>
 * Example 2:
 * Input: heights = [5,1,2,3,4]
 * Output: 5
 * Explanation:
 * heights:  [5,1,2,3,4]
 * expected: [1,2,3,4,5]
 * All indices do not match.
 *<p/>
 * Example 3:
 * Input: heights = [1,2,3,4,5]
 * Output: 0
 * Explanation:
 * heights:  [1,2,3,4,5]
 * expected: [1,2,3,4,5]
 * All indices match.
 */
public class HeightChecker {

    public static void main(String[] args) {
        int[] input = {1, 1, 4, 2, 1, 3};
        int answer = heightChecker(input);
        System.out.println("Answer: " + answer);
    }

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static int heightChecker(int[] heights) {
        int indices = 0;
        int[] helper = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            helper[i] = heights[i];
        }
        Arrays.sort(helper);
        for (int i = 0; i < heights.length; i++) {
            int helperInt = helper[i];
            int heightInt = heights[i];
            if (helperInt != heightInt) {
                indices++;
            }
        }
        return indices;
    }
}
