package interview.collection;

/**
 * <b>Remove Nth Node From End of List</b>
 * <p></p>
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * <p></p>
 * <b>Example 1:</b>
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * <p></p>
 * <b>Example 2:</b>
 * Input: head = [1], n = 1
 * Output: []
 * <p></p>
 * <b>Example 3:</b>
 * Input: head = [1,2], n = 1
 * Output: [1]
 */
public class RemoveNodeFromEndList {

    public static void main(String[] args) {

        ListNode head = new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7))));
        //ListNode head = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
        int n = 7;
        ListNode answer = removeElements(head, n);
        while (answer != null) {
            System.out.println("Answer: " + answer);
            answer = answer.next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        // Once removeElements call is done, right side of the list is solved.
        ListNode rightSideHead = removeElements(head.next, val);
        if (head.val == val) {
            return rightSideHead;
        }
        head.next = rightSideHead;
        return head;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int size = size(head);
        if (size <= n) {
            return head.next;
        }
        size = size(head) - n;
        int inc = 0;

        ListNode answer = head;
        while (answer != null) {
            inc++;
            if (inc == size) {
                answer.next = answer.next.next;
                return head;
            } else {
                answer = answer.next;
            }
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
