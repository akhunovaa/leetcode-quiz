package set;

import java.util.*;

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
        for(int i: nums1){
            numSet.add(i);
        }
        for(int i: nums2){
            if(numSet.contains(i))resultSet.add(i);
        }
        int[] resArr = new int[resultSet.size()];

        int idx = 0;
        for(int i: resultSet){
            resArr[idx++] = i;
        }
        return resArr;
    }

    public boolean isHappy(int n) {
        int res = n;
        Set<Integer> set = new HashSet<>();

        while(res != 1) {
            if(!set.contains(res)) {
                set.add(res);
                res = sumOfDigitsquare(res);
            } else {
                break;
            }
        }

        return res == 1;
    }

    private int sumOfDigitsquare (int n) {
        int sum = 0;
        if (n >= 10) {
            while(n >= 10) {
                int cur = n%10;
                sum += Math.pow(cur, 2);
                n = n/10;
            }

        }
        sum += Math.pow(n,2);
        return sum;
    }
}
