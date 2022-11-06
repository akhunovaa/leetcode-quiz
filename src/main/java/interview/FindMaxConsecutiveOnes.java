package interview;

public class FindMaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] input = {1, 1, 0, 1, 1, 1};
        int answer = findMaxConsecutiveOnes(input);
        System.out.println("Answer: " + answer);
    }

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static int findMaxConsecutiveOnes(int[] nums) {
        int answer = 0;
        int inc = 0;
        for (int num : nums) {
            if (num == 0) {
                inc = 0;
            } else {
                inc++;
            }
            if (inc > answer) {
                answer = inc;
            }
        }
        return answer;
    }
}
