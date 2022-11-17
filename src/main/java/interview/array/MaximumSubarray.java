package interview.array;

/**
 * <b>Maximum Subarray</b>
 * <p></p>
 * Given an integer array nums, find the subarray which has the largest sum and return its sum.
 * <p></p>
 * <b>Example 1:</b>
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * <p></p>
 * <b>Example 2:</b>
 * Input: nums = [1]
 * Output: 1
 * <p></p>
 * <b>Example 3:</b>
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {4000, 3000, 1000, 2000};
        int answer = maxSubArray(nums);
//        System.out.println("Answer: " + answer);
//        System.out.println(average(nums));
        System.out.println(min(new int[]{66, 7, 8, 3, 6, 999999, 8, -56, -55, -5423, 9999}));
//        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
//        int target = 15;
//        int ans = searchBin(input, target);
//        System.out.println("ANS: " + ans);
    }

    static int min(int[] arr) {
        int min = arr[0];
        int min2 = arr[1];
        int start = 2;
        int end = arr.length - 1;
        while (start < end) {
            if (arr[start] < min) {
                min2 = min;
                min = arr[start];
            } else if (arr[start] < min2) {
                min2 = arr[start];
            }
            if (arr[end] < min) {
                min2 = min;
                min = arr[end];
            } else if (arr[end] < min2) {
                min2 = arr[end];
            }

            start++;
            end--;
        }
        return min2;
    }

    static int searchBin(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            if (arr[start] == target) {
                return start;
            } else if (arr[end] == target) {
                return end;
            }
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    static int min2(int[] arr) {
        int min = arr[0];
        int max = arr[arr.length - 1];
        int start = 1;
        int end = arr.length - 1;
        while (start < end) {
            min = Math.min(arr[start], min);
            min = Math.min(arr[end], min);
            max = Math.max(arr[start], max);
            max = Math.max(arr[end], max);
            start++;
            end--;
        }
        return min;
    }

    public static double average(int[] salary) {
        if (salary.length == 0) {
            return 0.00;
        }

        int min = salary[0];
        int max = salary[salary.length - 1];

        int totalSum = 0;

        for (int i = 0; i < salary.length; i++) {
            int curSalary = salary[i];
            totalSum += curSalary;
            if (curSalary < min) {
                min = curSalary;
            }
            if (curSalary > max) {
                max = curSalary;
            }
        }
        totalSum = totalSum - max - min;
        return (double) totalSum / (salary.length - 2);

    }

    public static int maxSubArray(int[] nums) {

        int maxSoFar = nums[0], maxEndingHere = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
