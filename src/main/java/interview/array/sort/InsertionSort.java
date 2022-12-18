package interview.array.sort;

import java.util.Arrays;

/**
 * <b>Insertion Sort</b>
 * <p/>
 * Going back to our pile of books analogy, where we attempted to sort by weight, let's explore another approach
 * to sorting the pile of books. We'll start at the top of the pile and iterate over the books one by one. Every time
 * we encounter a book that is lighter than the book above it, we'll move the book up until it is in its
 * appropriate place. Repeating this for the entire pile of books, we will get the books in sorted order.
 * <p/>
 * This is the core intuition behind insertion sort. Given a collection of integers, you can sort the list by
 * proceeding from the start of the list, and every time you encounter an element that is out of order, you can continuously
 * swap places with previous elements until it is inserted in its correct relative location based on what you’ve
 * processed thus far.
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 5, 3, 6, 9, 99, 76, 43, 23, 66, 94, 32, 49};
        insertionSort(nums);
        System.out.println("Answer: " + Arrays.toString(nums));
    }

    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currentIndex = i; // 10   9      // 9  8   >     10 9
            while (currentIndex > 0 && arr[currentIndex - 1] > arr[currentIndex]) {
                int temp = arr[currentIndex]; // 10
                arr[currentIndex] = arr[currentIndex - 1];
                arr[currentIndex - 1] = temp;
                currentIndex--; // 10 => 9
            }

        }
    }
}
