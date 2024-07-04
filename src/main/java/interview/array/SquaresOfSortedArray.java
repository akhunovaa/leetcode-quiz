package interview.array;

import java.util.Arrays;

public class SquaresOfSortedArray {

    public static void main(String[] args) {
        int[] input = {-4, -1, 0, 3, 10};
        // int[] input = {10};
        int[] answer = sortedSquares(input);
        System.out.println("Answer: " + Arrays.toString(answer));

    }

    public static int[] sortedSquares(int[] nums) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            int k = power(num, num);
            a[i] = k;
        }
        Arrays.sort(a);
        return a;
    }


    static int power(int input, int power) {
        if (input == 0) {
            return 0;
        }
        int answer = input;
        while (!isPowerOfTwo(input)) {
            input -= 1;
        }
        int shift = log2(input);
        return power(answer - input, power) + (power << shift);
    }

    static boolean isPowerOfTwo(int x) {
        return (x & (x - 1)) == 0;
    }

    static int log2(int n) {
        int idx = 0;
        while (n > 1) {
            n = n >> 1;
            idx++;
        }
        return idx;
    }

    static int swap(int x) {
        // swap nibbles
        x = x >>> 4 | x << 4;
// swap groups of 2
        x = (x >>> 2) & 0x33 | (x & 0x33) << 2;
// swap groups of 1
        x = (x >>> 1) & 0x55 | (x & 0x55) << 1;
        return x;
    }

}
