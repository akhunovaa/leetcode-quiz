package interview.array.sort;

import java.util.Arrays;

/**
 * <b>Bubble Sort</b>
 * <p/>
 * Conceptually, bubble sort is an implementation of a rather simple idea. Suppose we have a collection of
 * integers that we want to sort in ascending order. Bubble sort proceeds to consider two adjacent elements
 * at a time. If these two adjacent elements are out of order (in this case, the left element is strictly greater
 * than the right element), bubble sort will swap them. It then proceeds to the next pair of adjacent elements. In the first
 * pass of bubble sort, it will process every set of adjacent elements in the collection once, making swaps
 * as necessary. The core idea of bubble sort is it will repeat this process until no more swaps are made in
 * a single pass, which means the list is sorted.
 * <p/>
 * In terms of the running time of the algorithm, bubble sort’s runtime is entirely based on the number of passes
 * it must make in the array until it’s sorted. If the array has n elements, each pass will consider <b>(n−1)</b> pairs. In the worst case,
 * when the minimum element is at the end of the list, it will take <b>(n−1)</b> passes to get it to the proper place at the front of the
 * list, and then one more additional pass to determine that no more swaps are needed. Bubble sort, as a result, has
 * worst case runtime of <b>O(n^2)</b>. The space complexity of bubble sort is <b>O(1)</b>. All sorting operations involve
 * swapping adjacent elements in the original input array, so no additional space is required.
 * <p/>
 * Bubble sort is also a stable sorting algorithm since equal elements will never have swapped places,
 * so their relative ordering will be preserved.
 * <p/>
 * Overall, bubble sort is fairly simple to implement, and it’s stable, but outside of that, this algorithm does not have
 * many desirable features. It’s fairly slow for most inputs and, as a result, it is rarely used in practice.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 5, 3, 6, 9, 99, 76, 43, 23, 66, 94, 32, 49};
        bubbleSort(nums);
        System.out.println("Answer: " + Arrays.toString(nums));
    }

    static void bubbleSort(int[] arr) {
        boolean hasSwapped = true;
        while(hasSwapped) {
            hasSwapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if(arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    hasSwapped = true;
                }
            }
        }
    }
}
