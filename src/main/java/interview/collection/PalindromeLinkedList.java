package interview.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Palindrome Linked List</b>
 * <p></p>
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 * <p></p>
 * <b>Example 1:</b>
 * Input: head = [1,2,2,1]
 * Output: true
 * <p></p>
 * <b>Example 2:</b>
 * Input: head = [1,2]
 * Output: false
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        boolean answer = isPalindrome(head);
        System.out.println("Answer: " + answer);
    }


    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode endOfFirstHalf = getLastOfFirstHalf(head);
        ListNode reversedSecondHalf = reverseListNode(endOfFirstHalf.next);

        ListNode p1 = head;
        ListNode p2 = reversedSecondHalf;
        boolean answer = true;
        while (answer && p2 != null) {
            if (p1.val != p2.val) {
                answer = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        endOfFirstHalf.next = reverseListNodeRecursively(reversedSecondHalf);
        return answer;
    }

    private static ListNode reverseListNode(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode tempNextListNode = current.next;
            current.next = prev;
            prev = current;
            current = tempNextListNode;
        }
        return prev;
    }

    private static ListNode reverseListNodeRecursively(ListNode head) {
        // граничный случай
        // больше необходим для рекрсивного вызова для понимания границы последнего элемента
        if (head == null || head.next == null) {
            return head;
        }

        // при помощи рекурсии доходим до последнего элемента в списке и устанавливаем его на переменную res => [value: 5]
        ListNode res = reverseListNodeRecursively(head.next);

        head.next.next = head;
        head.next = null;

        return res;
    }

    private static ListNode getLastOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static boolean isPalindromeList(ListNode head) {
        if (head == null) {
            return false;
        }
        List<Integer> integerList = new ArrayList<>();
        while (head != null) {
            integerList.add(head.val);
            head = head.next;
        }

        // use two-pointer technique to check for palindrome
        int start = 0;
        int end = integerList.size() - 1;
        while (start < end) {
            int st = integerList.get(start++);
            int ed = integerList.get(end--);
            if (st != ed) {
                return false;
            }
        }
        return true;
    }

}
