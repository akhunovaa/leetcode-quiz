package interview.array;

public class SumAllOddLengthSubarrays {

    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 5, 3};
        int answer = sumOddLengthSubarraysLinear(nums);
        System.out.println("Answer: " + answer);
    }

    static int sumOddLengthSubarraysLinear(int[] arr) {
        int n = arr.length, answer = 0;

        for (int i = 0; i < n; ++i) {
            int left = i, right = n - i - 1;
            answer += arr[i] * (left / 2 + 1) * (right / 2 + 1);
            answer += arr[i] * ((left + 1) / 2) * ((right + 1) / 2);
        }

        return answer;
    }

    static int sumOddLengthSubarraysQuad(int[] arr) {
        int n = arr.length, answer = 0;

        for (int left = 0; left < n; ++left) {
            int currentSum = 0;
            for (int right = left; right < n; ++right) {
                currentSum += arr[right];
                answer += (right - left + 1) % 2 == 1 ? currentSum : 0;
            }
        }
        return answer;
    }

    static int sumOddLengthSubarraysCube(int[] arr) {
        int n = arr.length, answer = 0;

        for (int left = 0; left < n; ++left) {
            for (int right = left; right < n; ++right) {
                if ((right - left + 1) % 2 == 1) {
                    int currentSum = 0;
                    for (int index = left; index < right + 1; ++index) {
                        currentSum += arr[index];
                    }
                    answer += currentSum;
                }
            }
        }
        return answer;
    }
}
