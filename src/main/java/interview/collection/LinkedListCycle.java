package interview.collection;

/**
 * <b>Linked List Cycle</b>
 * <p></p>
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
 * following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer
 * is connected to. Note that pos is not passed as a parameter.
 * <p></p>
 * <b>Return</b> <b><i>true</i></b> if there is a cycle in the linked list. Otherwise, return <b><i>false</i></b>.
 */
public class LinkedListCycle {

    public static void main(String[] args) {

        ListNode last = new ListNode(5);
        ListNode third = new ListNode(3,
                new ListNode(4, last));
        last.next = third;
        ListNode head = new ListNode(1,
                new ListNode(2, third));
//
//        boolean answer = hasCycle(head);
//        System.out.println("Answer: " + answer);
        System.out.println("Answer: " + titleToNumber("AB"));
    }


    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static int titleToNumber(String columnTitle) {
        int sum = 0;
        for(char ch : columnTitle.toCharArray()) {

            int diff = ch - ('A' - 1);
            sum = sum * 26 + diff;
        }
        return sum;
    }
}
