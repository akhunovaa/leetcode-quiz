package interview.array;

import java.util.Arrays;

public class DuplicateZeros {

    public static void main(String[] args) {
        int[] input = {-4, -1, 0, 3, 10};
        duplicateZeros(input);

    }

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static void duplicateZeros(int[] arr) {
        int possibleDups = 0;
        int length_ = arr.length - 1;

        for (int left = 0; left <= length_ - possibleDups; left++) {
            if (arr[left] == 0) {
                if (left == length_ - possibleDups) {
                    arr[length_] = 0;
                    length_ -= 1;
                    break;
                }
                possibleDups++;
            }
        }

        int last = length_ - possibleDups;

        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleDups] = 0;
                possibleDups--;
                arr[i + possibleDups] = 0;
            } else {
                arr[i + possibleDups] = arr[i];
            }
        }
    }
}
