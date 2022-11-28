package interview.collection;

/**
 * <b>Swap Nodes in Pairs</b>
 * <p></p>
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the
 * problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 * <p></p>
 * <b>Example 1:</b>
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * <p></p>
 * <b>Example 3:</b>
 * Input: head = []
 * Output: []
 * <p></p>
 * <b>Example 4:</b>
 * Input: head = [1]
 * Output: [1]
 */
public class SwapNodesPairs {

    public static void main(String[] args) {

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode answer = swapPairs(head);
        while (answer != null) {
            System.out.println("Answer: " + answer);
            answer = answer.next;
        }

    }

    static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = new ListNode();
        prev.next = head;
        ListNode dummy = prev;
        while (prev.next != null && prev.next.next != null) {
            ListNode a = prev.next; // a = [value: 1] // a = [value: 3]
            ListNode b = a.next; //  b = [value: 2] // b = [value: 4]
            a.next = b.next; // a.next [value: 2] => b.next [value: 3] // a.next [value: 4] => b.next [null]
            b.next = a; // b.next [value: 3] => a [value: 1] // b.next [null] => a [value: 3]
            prev.next = b; // prev.next [value: 1] => b [value: 2] // prev.next [value: 3] => b [value: 4]
            prev = prev.next.next; // prev [value: 0] => prev.next [value: 2] => prev.next.next [value: 1]
                                    // prev [value: 1] => prev.next [value: 4] => prev.next.next [value: 3]
        }
        return dummy.next;
    }

}
