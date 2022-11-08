package interview.array;

import java.util.Arrays;

/**
 * <b>Median of Two Sorted Arrays</b>
 * <p/>
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * <p></p>
 * <b>Example 1:</b>
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * <p></p>
 * <b>Example 2:</b>
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
public class MedianTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double answer = findMedianSortedArrays(nums1, nums2);
        System.out.println("Answer: " + answer);
    }

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0.00;
        if (nums1.length == 0 && nums2.length == 0) {
            return median;
        }
        int firstLength = nums1.length;
        int secLength = nums2.length;
        int[] mergedArray = new int[firstLength + secLength];
        for (int i = 0; i < firstLength; i++) {
            mergedArray[i] = nums1[i];
        }
        for (int i = 0; i < secLength; i++) {
            mergedArray[firstLength + i] = nums2[i];
        }
        Arrays.sort(mergedArray);
        int n = mergedArray.length;
        if (n % 2 == 1) {
            median = mergedArray[(n + 1) / 2 - 1];
        } else {
            median = (double)(mergedArray[n / 2 - 1] + mergedArray[n / 2]) / 2;
        }
        return median;
    }

}
