package easy;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        int[] answer = twoSum2(nums, target);
        System.out.println(Arrays.toString(answer));
    }

    /*
    Time complexity : O(n^2)
    Space complexity : O(1)
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /*
    Time complexity : O(n)
    Space complexity : O(n)
    */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // 9 - 2 = 7
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /*
    Time complexity : O(n)
    Space complexity : O(n)
    */
    public int[] twoSum3(int[] nums, int target) {//nums = {2, 11, 7, 15} target = 9
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // 9 - 2
            if (map.containsKey(complement)) {//7
                return new int[]{map.get(complement), i};// возвращаем индексы данных значений 2 с индексом 0 (который уже был добавлен) и 7 с индексом 2
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
