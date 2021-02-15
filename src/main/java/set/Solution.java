package set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashset = new HashSet<>(nums.length);
        for (int key : nums) {
            if (hashset.contains(key)) {
                return true;
            }
            hashset.add(key);
        }
        return false;
    }

    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i : nums) {
            // {4, 1, 2, 1, 2};
            // если исключаем 0 по числу, оно превратится в это число.
            // если вы исключаем это число на само себя, оно превратится в 0
            // следовательно, последнее оставшееся число и будет числом одиночкой
            a ^= i;
        }
        return a;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numSet = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();
        for (int i : nums1) {
            numSet.add(i);
        }
        for (int i : nums2) {
            if (numSet.contains(i)) resultSet.add(i);
        }
        int[] resArr = new int[resultSet.size()];

        int idx = 0;
        for (int i : resultSet) {
            resArr[idx++] = i;
        }
        return resArr;
    }

    public boolean isHappy(int n) {
        int res = n;
        Set<Integer> set = new HashSet<>();

        while (res != 1) {
            if (!set.contains(res)) {
                set.add(res);
                res = sumOfDigitsquare(res);
            } else {
                break;
            }
        }

        return res == 1;
    }

    private int sumOfDigitsquare(int n) {
        int sum = 0;
        if (n >= 10) {
            while (n >= 10) {
                int cur = n % 10;
                sum += Math.pow(cur, 2);
                n = n / 10;
            }

        }
        sum += Math.pow(n, 2);
        return sum;
    }

    /*
     * Template for using hash map to find duplicates.
     * Replace ReturnType with the actual type of your return value.
     */
//    ReturnType aggregateByKey_hashmap(List<Type>& keys) {
//        // Replace Type and InfoType with actual type of your key and value
//        Map<Type, InfoType> hashmap = new HashMap<>();
//        for (Type key : keys) {
//            if (hashmap.containsKey(key)) {
//                if (hashmap.get(key) satisfies the requirement) {
//                    return needed_information;
//                }
//            }
//            // Value can be any information you needed (e.g. index)
//            hashmap.put(key, value);
//        }
//        return needed_information;
//    }

    /*
    Time complexity : O(n^2)
    Space complexity : O(1)
     */
    public int[] twoSum(int[] nums, int target) {
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
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
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
