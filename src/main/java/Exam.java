import java.util.Arrays;
import java.util.List;

public class Exam {

    public static void main(String[] args) {

        Solution solution = new Solution();
        //int[] nums = {3, 5, 7, 8, 4, 2, 1, 9, 6};

        //int[] nums = {4, 2, 1, 5, 3};
        //int[] nums = {4, 1, 2, 4, 2};
//
//        int[] nums = {0, 1, 2, 3, 0, 5, 6, 7, 8, 9};
//        int[] nums = {0, 1, 2, 3, 0, 5, 6, 7, 8, 9, 0, 1, 2, 3, 0, 5, 6, 7, 8, 9};
//        int[] nums = {x, x, x, x, 0, x, x, x, x, x, x, x, x, x, 4, x, x, x, x, x};

        //int[] answer = solution.mergeSort(nums, 0, nums.length - 1);
//        int[] answer = solution.quickSort(nums, 0, nums.length - 1);
        //System.out.println("Sum of this array: " + Arrays.toString(answer) + " will give the target: " + target);
//        System.out.println(Arrays.toString(answer));
//        Ulam ulam = new Ulam(809);
//        ulam.printPrimes();
//        int x = 1;
//        int y = 0;
//        x ^= y;
//        y ^= x;
//        x ^= y;
//        System.out.println(x);
//        System.out.println(y)
//        boolean answer = solution.hasUniqueChars("azat");
//        System.out.println(answer);
//        int answer = solution.reverse(123);
//        boolean answer = solution.isPalindrome("adaa");
//        System.out.println(answer);
        int[][] nums = {
                {1,2,3}, // 1,2,3
                {4,5,6}, // 4,5,6
                {7,8,9}  // 7,8,9
        };
        // [1, 2, 4, 7, 5, 3, 6, 8, 9]
        //List<Integer> answer = solution.spiralOrder(nums);
        String answer = solution.addBinary("111", "1");
        System.out.println("Answer is: " + answer);
    }

    private void run() {
//        System.out.println("Best conference:");
//        http:// это метка и // это комментарий к коду
//        return;
    }
}
