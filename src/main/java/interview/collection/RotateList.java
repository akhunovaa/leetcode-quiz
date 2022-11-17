package interview.collection;

/**
 * <b>Rotate List</b>
 * <p></p>
 * Given the head of a linked list, rotate the list to the right by k places.
 * <p></p>
 * <b>Example 1:</b>
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * <p></p>
 * <b>Example 2:</b>
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 */
public class RotateList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));
        int k = 2;
        ListNode answer = rotateRight(head, k);
        while (answer != null) {
            System.out.println("Answer: " + answer);
            answer = answer.next;
        }

    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int len = findLength(head);
        if (k == 0) {
            return head;
        }
        k = k % len;
        ListNode temp = head;
        for (int i = 1; i < len - k; i++) {
            temp = temp.next;
        }
        ListNode store = temp.next;
        temp.next = null;
        temp = store;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        return store;
    }

    static int findLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "[value: " + val + "]";
        }
    }
}
