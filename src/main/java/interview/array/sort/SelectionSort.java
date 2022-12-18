package interview.array.sort;

import java.util.Arrays;

/**
 * <b>Selection Sort</b>
 * <p/>
 * Suppose you had to sort a pile of books by their weight, with the heaviest book on the
 * bottom and the lightest book on the top. One reasonable method of sorting is to go through your books,
 * find the heaviest book, and then place that at the bottom. After that, you can then find the next heaviest
 * book in the remaining pile of books and place that on top of the heaviest book. You can continue this approach
 * until you have a sorted pile of books. This concept is exactly what the selection sort does.
 * <p/>
 * Suppose we had a collection of elements where every element is an integer. Selection sort will build up the
 * sorted list by repeatedly finding the minimum element in that list and moving it to the front of the list
 * through a swap. It will proceed to swap elements appropriately until the entire list is sorted.
 * <p/>
 * In terms of simplicity, it is a highly intuitive algorithm and not too difficult to write. Unfortunately,
 * it is pretty slow, requiring <b>O(n^2)</b> time to sort the list in the worst case. In the worst case,
 * we have to search the entire array to find the minimum element, meaning we can have up to
 * n+(n−1)+(n−2)+…+1 total operations, which is <b>O(n^2)</b>. The space complexity of selection sort is <b>O(1)</b>
 * since we do not use any additional space during the algorithm (all operations are in-place).
 * <p/>
 * It also is not a stable sorting algorithm. For example consider the collection <b>[4, 2, 3, 4, 1]</b>. After the first round
 * of selection sort, we get the array <b>[1, 2, 3, 4, 4]</b>. This array is sorted, but it does not preserve the ordering of equal elements.
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 5, 3, 6, 9, 99, 76, 43, 23, 66, 94, 32, 49};
        selectionSort(nums);
        System.out.println("Answer: " + Arrays.toString(nums));
    }

    static void selectionSort(int[] arr) {
        int minIdx;
        for (int i = 0; i < arr.length; i++) {
            minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
}
