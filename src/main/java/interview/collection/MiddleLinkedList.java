package interview.collection;

/**
 * <b>Middle of the Linked List</b>
 * <p></p>
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 * <p></p>
 * <b>Example 1:</b>
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 * <p></p>
 * <b>Example 2:</b>
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 */
public class MiddleLinkedList {


    public static void main(String[] args) {

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        ListNode answer = middleNode(head);
        while (answer != null) {
            System.out.println("Answer: " + answer);
            answer = answer.next;
        }
    }

    public static ListNode middleNode(ListNode head) {
        int size = size(head);
        int middle = size / 2 + 1;
        ListNode answer = head;
        while (answer != null && middle > 1) {
            answer = answer.next;
            middle--;
        }
        return answer;
    }

    private static int size(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }

}
