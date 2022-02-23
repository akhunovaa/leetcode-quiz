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

    //    public int singleNumber2(int[] nums) {
//        int result = 0;
//        int[] count = new int[list.size() - 1];
//        for (int i = 1; i <= n + 1; i++) {
//            result ^= i;
//        }
//
//        for (int i : nums) {
//            result ^= i;
//        }
//
//        return result;
//    }
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

    // Selection Sort
    // Сортировка выбором
    public int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            //берем [i + 1] элемент из массива
            int current = array[i];
            //берем [0] индекс массива
            int j = i - 1;
            //итерируем пока о не станет ближе к нулю или равным нулю
            //и пока второй элемент из массива не будет меньше первого элемента
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

    //Сортировка слиянием
    //Merge Sort
    // O(n ^ 2) наихудший случай
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

    //O(nlog n)
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

    //Пирамидальная сортировка
    //Heap Sort
    void merge(int[] array, int left, int mid, int right) {
        // вычисляем длину
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;

        // создаем временные подмассивы
        int[] leftArray = new int[lengthLeft];
        int[] rightArray = new int[lengthRight];

        // копируем отсортированные массивы во временные
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
     * прыжками к родителям каждого узла в отношении i/2. Всего потребуется log
     * n прыжков до вершины, значит, сложность равна O(log n). Это ещё не всё! В
     * связи с циклами for, которые итерируют весь массив, сложность heapSort()
     * равна O(n). Это дает нам суммарную сложность пирамидальной сортировки
     * O(nlog n).
     */
    // сложность O(nlog n)
    public int[] heapSort(int[] array) {
        if (array.length == 0) {
            return array;
        }

        // Строим кучу
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

    // Быстрая сортировка
    // Quick Sort
    // O(n^2)
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
     * :( На практике быстрая сортировка применяется широко. Судите сами: у
     * алгоритма очень хорошее среднее время запуска, также равное O(nlog n), он
     * эффективен для больших потоков ввода. И на этом преимущества не
     * заканчиваются! Алгоритм не занимает дополнительного пространства, вся
     * сортировка происходит «на месте», отсутствуют затратные вызовы
     * распределения, из-за чего его часто предпочитают сортировке слиянием.
     */
    //сложность O(n^2)
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
            if (map.containsKey(complement)) {//7
                return new int[]{map.get(complement), i};// возвращаем индексы данных значений 2 с индексом 0 (который уже был добавлен) и 7 с индексом 2
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
}

