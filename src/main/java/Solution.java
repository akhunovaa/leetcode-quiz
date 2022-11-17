import list.ListNode;
import other.Phone;

import java.util.*;
import java.util.stream.Stream;

public class Solution {

    static int partition(int[] array, int begin, int end) {
        int pivot = end;

        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;

        return counter;
    }

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

    /*
     1 ^ 0 = 1
     1 ^ 1 = 0
     0 ^ 0 = 0
     0 ^ 1 = 1
     */
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
        for (int i : nums1) {
            numSet.add(i);
        }
        for (int i : nums2) {
            if (numSet.contains(i)) {
                resultSet.add(i);
            }
        }
        int[] resArr = new int[resultSet.size()];

        int idx = 0;
        for (int i : resultSet) {
            resArr[idx++] = i;
        }
        return resArr;
    }

    public boolean isHappy(int n) {
        int res = n;
        Set<Integer> set = new HashSet<>();

        while (res != 1) {
            if (!set.contains(res)) {
                set.add(res);
                res = sumOfDigitsquare(res);
            } else {
                break;
            }
        }

        return res == 1;
    }

    private int sumOfDigitsquare(int n) {
        int sum = 0;
        if (n >= 10) {
            while (n >= 10) {
                int cur = n % 10;
                sum += Math.pow(cur, 2);
                n = n / 10;
            }

        }
        sum += Math.pow(n, 2);
        return sum;
    }

    // O(n ^ 2) наихудший случай
    public void bubbleSort2(int[] array) {
        boolean sorted = false;
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
                }
            }
        }
    }

    // O(n ^ 2) наихудший случай
    public int[] bubbleSort(int[] array) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    array[i] = array[i] ^ array[i + 1];
                    array[i + 1] = array[i] ^ array[i + 1];
                    array[i] = array[i] ^ array[i + 1];
                    sorted = false;
                }
            }
        }
        return array;
    }

    // | Selection Sort | Сортировка выбором |
    // Сложность алгоритма: O(n2) КВАДРАТИЧНАЯ
    public int[] selection33Sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            // берем [i + 1] элемент из массива
            int current = array[i];
            // берем [0] индекс массива
            int j = i - 1;
            // итерируем пока о не станет ближе к нулю или равным нулю
            // и пока второй элемент из массива не будет меньше первого элемента
            while (j >= 0 && current < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            // в этой точке мы вышли, так что j так же -1
            // или в первом элементе, где текущий >= a[j]
            array[j + 1] = current;
        }
        return array;
    }

    // | Selection Sort | Сортировка выбором |
    // Сложность алгоритма: O(n2) КВАДРАТИЧНАЯ
    public int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minId = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minId = j;
                }
            }
            // замена
            array[i] = array[i] ^ array[minId];
            array[minId] = array[i] ^ array[minId];
            array[i] = min;
        }
        return array;
    }

    // Merge sort | Сортировка слиянием |
    // Сложность алгоритма: O(nlog n) КВАЗИ-ЛИНЕЙНАЯ
    public int[] mergeSort(int[] array, int left, int right) {
        if (right <= left) {
            return array;
        }
        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
        return array;
    }

    void merge(int[] array, int left, int mid, int right) {
        // вычисляем длину
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;
        // создаем временные подмассивы
        int[] leftArray = new int[lengthLeft];
        int[] rightArray = new int[lengthRight];
        // копируем отсортированные массивы во временные
        // System.arraycopy(array, left, leftArray, 0, lengthLeft);
        for (int i = 0; i < lengthLeft; i++) {
            leftArray[i] = array[left + i];
        }
        for (int i = 0; i < lengthRight; i++) {
            rightArray[i] = array[mid + i + 1];
        }
        // итераторы содержат текущий индекс временного подмассива
        int leftIndex = 0;
        int rightIndex = 0;
        // копируем из leftArray и rightArray обратно в массив
        for (int i = left; i < right + 1; i++) {
            // если остаются нескопированные элементы в R и L, копируем минимальный
            if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            } // если все элементы были скопированы из rightArray, скопировать остальные из leftArray
            else if (leftIndex < lengthLeft) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            } // если все элементы были скопированы из leftArray, скопировать остальные из rightArray
            else if (rightIndex < lengthRight) {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }

    /**
     * В худшем случае рекурсивный вызов дойдет до самой вершины пирамиды
     * прыжками к родителям каждого узла в отношении i/2. Всего потребуется log n прыжков
     * до вершины, значит, сложность равна O(log n). Это ещё не всё!
     * В связи с циклами for, которые итерируют весь массив, сложность heapSort() равна O(n).
     * Это дает нам суммарную сложность пирамидальной сортировки O(nlog n).
     */
    // Heap sort | Пирамидальная сортировка |
    // Сложность алгоритма: O(nlog n) КВАЗИ-ЛИНЕЙНАЯ
    public int[] heapSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int length = array.length;
        // проходим от первого без ответвлений к корню
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }
        for (int i = length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
        return array;
    }


    /*
     * Template for using hash map to find duplicates.
     * Replace ReturnType with the actual type of your return value.
     */
//    ReturnType aggregateByKey_hashmap(List<Type>& keys) {
//        // Replace Type and InfoType with actual type of your key and value
//        Map<Type, InfoType> hashmap = new HashMap<>();
//        for (Type key : keys) {
//            if (hashmap.containsKey(key)) {
//                if (hashmap.get(key) satisfies the requirement) {
//                    return needed_information;
//                }
//            }
//            // Value can be any information you needed (e.g. index)
//            hashmap.put(key, value);
//        }
//        return needed_information;
//    }

    public void heapify(int[] array, int length, int i) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int largest = i;
        // если левый дочерний больше родительского
        if (leftChild < length && array[leftChild] > array[largest]) {
            largest = leftChild;
        }
        // если правый дочерний больше родительского
        if (rightChild < length && array[rightChild] > array[largest]) {
            largest = rightChild;
        }
        // если должна произойти замена
        if (largest != i) {
            array[largest] = array[largest] ^ array[i];
            array[i] = array[largest] ^ array[i];
            array[largest] = array[largest] ^ array[i];
            heapify(array, length, largest);
        }
    }

    /**
     * На фоне алгоритмов сортировки со сложностью O(nlog n), выглядит не очень
     * На практике быстрая сортировка применяется широко. Судите сами: у
     * алгоритма очень хорошее среднее время запуска, также равное O(nlog n), он
     * эффективен для больших потоков ввода. И на этом преимущества не
     * заканчиваются! Алгоритм не занимает дополнительного пространства, вся
     * сортировка происходит «на месте», отсутствуют затратные вызовы
     * распределения, из-за чего его часто предпочитают сортировке слиянием.
     */
    // Quick Sort | Быстрая выбором |
    // Сложность алгоритма: O(n2) КВАДРАТИЧНАЯ
    public int[] quickSort(int[] array, int begin, int end) {
        if (end <= begin) {
            return array;
        }
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
        return array;
    }

    /*
    Time complexity : O(n^2)
    Space complexity : O(1)
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /*
    Time complexity : O(n)
    Space complexity : O(n)
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /*
    Time complexity : O(n)
    Space complexity : O(n)
     */
    public int[] twoSum3(int[] nums, int target) {//nums = {2, 11, 7, 15} target = 9
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // 9 - 2
            if (map.containsKey(complement)) { //7
                return new int[]{map.get(complement), i}; // возвращаем индексы данных значений 2 с индексом 0 (который уже был добавлен) и 7 с индексом 2
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public boolean hasUniqueChars(String str) {
        String test = str.toLowerCase();
        char[] cc = test.toCharArray();

        for (int i = 0; i < cc.length; i++) {
            char c = cc[i];
            for (int j = i + 1; j < cc.length; j++) {
                char x = cc[j];
                if ((x ^ c) == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public int reverse(int x) {
        int answer = 0;
        String temp = Integer.toString(x);
        int[] newGuess = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            newGuess[i] = temp.charAt(i) - '0';
        }
        newGuess[0] ^= newGuess[newGuess.length - 1];
        newGuess[newGuess.length - 1] ^= newGuess[0];
        newGuess[0] ^= newGuess[newGuess.length - 1];
        for (int i = 0; i < newGuess.length; i++) {
            int guess = newGuess[i];
            answer = answer * 10 + guess;
        }
        return answer;
    }

    public boolean isPalindrome(String text) {
        String reversed;
        char[] characters = text.toCharArray();
        int start = 0;
        int end = characters.length - 1;
        char temporaryChar;
        while (end > start) {
            temporaryChar = characters[start];
            characters[start] = characters[end];
            characters[end] = temporaryChar;
            start++;
            end--;
        }
        reversed = new String(characters);
        return text.equals(reversed);
    }

    public void streamCheckTest() {
        Stream.of(new Phone(1, "1"), new Phone(2, "2"))
                .map(Objects::toString)
                .peek(System.out::println)
                .peek(System.out::println)
                .filter(s -> s.startsWith("2"))
                .forEach(System.out::println);
    }

    public void anotherStreamCheckTest() {
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        myList.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }

    public void hashMapCheckTest() {
        HashMap<String, String> myHashMap = new HashMap<>();
        myHashMap.put("a1", "test");
        System.out.println(myHashMap.size());
        myHashMap.put(null, "null");
        System.out.println(myHashMap.size());
        System.out.println(myHashMap.get(null));
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        /* a dummy first node to hang the result on */
        ListNode dummyNode = new ListNode(0);

        /* tail points to the last result node */
        ListNode tail = dummyNode;

        while (true) {

            /* if either list runs out, use the other list */
            if (list1 == null) {
                tail.next = list2;
                break;
            }
            if (list2 == null) {
                tail.next = list1;
                break;
            }

        /* Compare the data of the two
        lists whichever lists' data is
        smaller, append it into tail and
        advance the head to the next Node
        */
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }

            /* Advance the tail */
            tail = tail.next;
        }
        return dummyNode.next;
    }

    //Time Complexity: O(N), where N is the length of nums.
    //Space Complexity: O(1), where the space used by leftsum and S.
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int leftsum = 0;
        for (int x : nums) {
            sum += x;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) {
                return i;
            }
            leftsum += nums[i];
        }
        return -1;
    }

    /*
    From end to start,
if the number[index] != 9, we plus one directly then quit the loop.
if the number[index] == 9, we set it to 0, and continue the loop until we encounter the number don't equals to 9.
After the loop, if number[0] == 0, it means that we need a bigger array to represent the number.
so we create a new array rst, and set rst[0] to 1.
/*
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
You may assume the integer do not contain any leading zero, except the number 0 itself.
The digits are stored such that the most significant digit is at the head of the list.
The description of this question is poor.
You can look the explianation here for better understanding:
suppose you have a number in your list/array such that adding 1 would make it a two digit number,
eg: [9]
output: [1,0]
Plusone(9) would be [10], but the expected output should be [1,0] such that the most significant digit is on the head
*/

    public int pivotIndex2(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        long sum = Arrays.stream(nums).sum();

        long prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {

            if (sum - prefixSum - nums[i] == prefixSum) {
                return i;
            }

            prefixSum += nums[i];
        }

        return -1;
    }

    // `x != m` with `m < 2*x`,
    public int dominantIndex(int[] nums) {
        int largest = 0;
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (largest <= num) {
                largest = num;
                maxIndex = i;
            }
        }
        for (int i : nums) {
            if (largest != i && largest < i << 1) {
                return -1;
            }
        }

        return maxIndex;
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }
        }
        if (digits[0] == 0) {
            int[] rst = new int[digits.length + 1];
            rst[0] = 1;
            return rst;
        }
        return digits;
    }

    /*
    Time Complexity: O(NM) since we process each element of the matrix exactly once.
Space Complexity: O(1) since we don't make use of any additional data structure.
Note that the space occupied by the output array doesn't count towards the space complexity since that is a requirement of the problem itself.
Space complexity comprises any additional space that we may have used to get to build the final array. For the previous solution,
it was the intermediate arrays.
In this solution, we don't have any additional space apart from a couple of variables.
      */
    public int[] findDiagonalOrder(int[][] matrix) {

        // Check for empty matrices
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        // Variables to track the size of the matrix
        int N = matrix.length;
        int M = matrix[0].length;

        // Incides that will help us progress through
        // the matrix, one element at a time.
        int row = 0, column = 0;

        // As explained in the article, this is the variable
        // that helps us keep track of what direction we are
        // processing the current diaonal
        int direction = 1;

        // The final result array
        int[] result = new int[N * M];
        int r = 0;

        // The uber while loop which will help us iterate over all
        // the elements in the array.
        while (row < N && column < M) {

            // First and foremost, add the current element to
            // the result matrix.
            result[r++] = matrix[row][column];

            // Move along in the current diagonal depending upon
            // the current direction.[i, j] -> [i - 1, j + 1] if
            // going up and [i, j] -> [i + 1][j - 1] if going down.
            int new_row = row + (direction == 1 ? -1 : 1);
            int new_column = column + (direction == 1 ? 1 : -1);

            // Checking if the next element in the diagonal is within the
            // bounds of the matrix or not. If it's not within the bounds,
            // we have to find the next head.
            if (new_row < 0 || new_row == N || new_column < 0 || new_column == M) {

                // If the current diagonal was going in the upwards
                // direction.
                if (direction == 1) {

                    // For an upwards going diagonal having [i, j] as its tail
                    // If [i, j + 1] is within bounds, then it becomes
                    // the next head. Otherwise, the element directly below
                    // i.e. the element [i + 1, j] becomes the next head
                    row += (column == M - 1 ? 1 : 0);
                    column += (column < M - 1 ? 1 : 0);

                } else {

                    // For a downwards going diagonal having [i, j] as its tail
                    // if [i + 1, j] is within bounds, then it becomes
                    // the next head. Otherwise, the element directly below
                    // i.e. the element [i, j + 1] becomes the next head
                    column += (row == N - 1 ? 1 : 0);
                    row += (row < N - 1 ? 1 : 0);
                }

                // Flip the direction
                direction = 1 - direction;

            } else {

                row = new_row;
                column = new_column;
            }
        }
        return result;
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        // Check for empty matrices
        if (matrix == null || matrix.length == 0) {
            return Collections.emptyList();
        }

        int rows = matrix.length; // row
        int cols = matrix[0].length; // column

        List<Integer> result = new ArrayList<>(rows * cols);
        // Defining the boundaries of the matrix.
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;

        // Defining the direction in which the array is to be traversed.
        int dir = 1;

        while (top <= bottom && left <= right) {

            if (dir == 1) {    // moving left->right
                for (int i = left; i <= right; ++i) {
                    System.out.print(matrix[top][i] + " ");
                    result.add(matrix[top][i]);
                }
                // Since we have traversed the whole first
                // row, move down to the next row.
                ++top;
                dir = 2;
            } else if (dir == 2) {     // moving top->bottom
                for (int i = top; i <= bottom; ++i) {
                    System.out.print(matrix[i][right] + " ");
                    result.add(matrix[i][right]);
                }
                // Since we have traversed the whole last
                // column, move left to the previous column.
                --right;
                dir = 3;
            } else if (dir == 3) {     // moving right->left
                for (int i = right; i >= left; --i) {
                    System.out.print(matrix[bottom][i] + " ");
                    result.add(matrix[bottom][i]);
                }
                // Since we have traversed the whole last
                // row, move up to the previous row.
                --bottom;
                dir = 4;
            } else {     // moving bottom->up
                for (int i = bottom; i >= top; --i) {
                    System.out.print(matrix[i][left] + " ");
                    result.add(matrix[i][left]);
                }
                // Since we have traversed the whole first
                // col, move right to the next column.
                ++left;
                dir = 1;
            }
        }
        return result;
    }

    public String addBinary2(String a, String b) {

        int len1 = a.length();
        int len2 = b.length();
        int carry = 0;
        StringBuilder res = new StringBuilder();
        // the final length of the result depends on the bigger length between b1
        // and b,
        // (also the value of carry, if carry = 1, add "1" at the head of result,
        // otherwise)
        int maxLen = Math.max(len1, len2);
        for (int i = 0; i < maxLen; i++) {
            // start from last char of String b1 and b2
            // notice that left side is an int and right side is char
            // so we need to minus the decimal value of '0'
            int p = i < len1 ? a.charAt(len1 - 1 - i) - '0' : 0;
            int q = i < len2 ? b.charAt(len2 - 1 - i) - '0' : 0;
            int tmp = p + q + carry;
            carry = tmp / 2;
            res.insert(0, tmp % 2);
        }
        return (carry == 0) ? res.toString() : "1" + res;
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public ArrayList<Integer> findDuplicate(int[] input) {
        System.out.println(Arrays.toString(input));
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < input.length - 1; i++) {
            int x = input[i];
            int y = input[i + 1];
            x = x ^ 0;
            x = x ^ x;
            x = x ^ y;
        }

        int offset = 1;
        int a = 0;
        for (int i = 0; i < input.length; i++) {
            a = a ^ (input[i] + offset) ^ i;
        }

        System.out.println(a);
        System.out.println(Arrays.toString(input));
        return arr;
    }

    public int doMethod() {
        int num1 = 2, num2 = 10;   //declaring values
        // bitwise XOR
        // 00000011 ^ 00000100 = 00000111 = 7
        int ans = num1 ^ num2;
        System.out.println("num1 XOR num2 = " + (ans));
        return ans;
    }

    public String multiply(String num1, String num2) {

        // Пограничные случаи
        if (num1.isEmpty() || num2.isEmpty()) {
            return "0";
        }
        if (num1.length() > 200 || num2.length() > 200) {
            return "0";
        }
        if (num1.startsWith("0") || num2.startsWith("0")) {
            return "0";
        }

        long answer = parseToDigit(num1) * parseToDigit(num2);
        return answer + "";
    }

    public String multiplyMethodTwo(String num1, String num2) {
        // Check for valid input
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("Input numbers are invalid");
        }

        int m = num1.length();
        int n = num2.length();

        // Base Conditions
        if (m == 0 || n == 0 || "0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        if ("1".equals(num1)) {
            return num2;
        }
        if ("1".equals(num2)) {
            return num1;
        }

        // Result can be maximum of length M + N.
        // For example 99 * 99 = 9801 (Result is of length 4)
        int[] result = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // Adding previous values in result array into this product.
                product += result[i + j + 1];

                // Adding the new product into the result array
                result[i + j + 1] = product % 10;
                result[i + j] += product / 10;
            }
        }

        // Generating the result String
        StringBuilder sb = new StringBuilder();
        for (int r : result) {
            // Ignoring leading zeros
            if (sb.length() == 0 && r == 0) {
                continue;
            }
            sb.append(r);
        }

        return sb.toString();
    }

    // Converting character to its integer value
    public static long parseToDigit(final String input) {
        final int len = input.length();
        final char ch = input.charAt(0);
        long num = '0' - ch;

        int i = 1;
        while (i < len) {
            num = num * 10 + '0' - input.charAt(i++);
        }
        return num;
    }

    public int searchInsert(int[] nums, int target) { //target = 60
        int numsSize = nums.length; // 100
        int mid =  numsSize / 2; // 50
        int right = numsSize - 1; // 99
        int idx = 0;
        while (idx <= right) {

            if (nums[mid] == target) {
                return mid;
            }



            if (target > nums[mid]) {
                if (nums.length == 1) {
                    return idx + 1;
                }
                mid =+ numsSize - mid / 2;
            }

            if (target < nums[mid]) {
                mid /= 2;
            }

            if (between(target, nums[Math.max(idx - 1, idx)], nums[Math.min(idx + 1, right)] )) {
                return idx;
            } else if (target <= nums[idx]) {
                return idx;
            }

            idx++;
        }
        return idx;
    }

    public static boolean between(int i, int minValueInclusive, int maxValueInclusive) {
        return (i >= minValueInclusive && i <= maxValueInclusive);
    }

    // Constraints:
    //              1 <= temperatures.length <= 10^5
    //              30 <= temperatures[i] <= 100
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<C> tempStack = new Stack<>();
        int[] answer = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!tempStack.isEmpty() && tempStack.peek().value <= temperatures[i]) {
                tempStack.pop();
            }

            if (!tempStack.isEmpty()) {
                answer[i] = tempStack.peek().index - i;
            }
            tempStack.push(new C(temperatures[i], i));
        }

        return answer;
    }

    static class C {
        int value;
        int index;

        public C(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public void moveZeroes(int[] nums) {
        int possibleZero = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num != 0) {
                nums[possibleZero++] =  nums[i];
            }
        }

        for (int i = possibleZero; i < nums.length; i++) {
            nums[i] = 0;

        }
    }
}

