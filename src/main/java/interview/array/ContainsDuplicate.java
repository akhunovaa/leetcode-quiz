package interview.array;

import java.util.Arrays;

public class ContainsDuplicate {

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        int[] nums2 = {1, 2, 3, 1};
        int[] nums3 = {1, 2, 3, 4};
        int[] nums4 = {1, 5, -2, -4, 0};

        boolean answer = containsDuplicate(nums);
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Answer: " + answer);
        System.out.println("===========================");
        answer = containsDuplicate(nums2);
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Answer: " + answer);
        System.out.println("===========================");
        answer = containsDuplicate(nums3);
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Answer: " + answer);
        System.out.println("===========================");
        answer = containsDuplicate(nums4);
        System.out.println("Input: " + Arrays.toString(nums4));
        System.out.println("Answer: " + answer);
    }


    static boolean containsDuplicate(int[] nums) {
        int a = 0;
        int max = nums[0];
        int min = nums[0];
        int offset = 1;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
            if(min > nums[i]) {
                min = nums[i];
            }
            a= a ^ (nums[i] + offset) ^ i;
        }

        System.out.println("min: " + min);
        System.out.println("max: " + max);
        System.out.println("a: " + a);
        return a != max;
    }

    static boolean containsDuplicate2(int[] nums) {

        int result = nums[0] ^ nums[1];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }

//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i - 1] != nums[i]) {
//                return false;
//            }
//        }
        System.out.println("result: " + result);
        return result != 0;
    }

    public static int log(int x, int base) {
        return (int) (Math.log(x) / Math.log(base));
    }

    static void findDuplicates(int[] arr, int n) {

        int result = arr[0] ^ arr[n + 1];
        for (int i = 1; i <= n; i++) {
            result = result ^ arr[i] ^ i;
        }

        int x = 0, y = 0;

        int k = log(result & -result, 2);

        for (int i = 0; i < n + 2; i++) {
            if ((arr[i] & (1 << k)) != 0) {
                x = x ^ arr[i];
            }
            else {
                y = y ^ arr[i];
            }
        }

        for (int i = 1; i <= n; i++) {
            if ((i & (1 << k)) != 0) {
                x = x ^ i;
            }else {
                y = y ^ i;
            }
        }

        System.out.println("The duplicate elements are " + x + " and " + y);
    }

}
