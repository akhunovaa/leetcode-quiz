package interview.array;

/**
 * <b>Decode XORed Array</b>
 * <p/>
 * There is a hidden integer array arr that consists of n non-negative integers. It was encoded into another integer array encoded of length n - 1, such that encoded[i] = arr[i] XOR arr[i + 1]. For example, if arr = [1,0,2,1], then encoded = [1,2,3].
 * You are given the encoded array. You are also given an integer first, that is the first element of arr, i.e. arr[0].
 * Return the original array arr. It can be proved that the answer exists and is unique.
 * <p/>
 * <b>Example 1:</b>
 * Input: encoded = [1,2,3], first = 1
 * Output: [1,0,2,1]
 * Explanation: If arr = [1,0,2,1], then first = 1 and encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
 * <p/>
 * <b>Example 2:</b>
 * Input: encoded = [6,2,7,3], first = 4
 * Output: [4,2,0,7,4]
 */
public class DecodeXORedArray {

    public static void main(String[] args) {
        int[] encoded = {1,2,3};
        int first = 1;
        int answer = decode(encoded, first);
        System.out.println("Answer: " + answer);
    }

    public static int decode(int[] encoded, int first) {
        int max = Integer.MAX_VALUE + 1;
        return max;
    }

}
