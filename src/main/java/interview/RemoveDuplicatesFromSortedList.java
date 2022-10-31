package interview;

public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(3, new ListNode(8))))))));
        ListNode answer = deleteDuplicates(head);
        System.out.println("Answer: " + answer);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode sentinel = new ListNode(0, head);
        ListNode pred = sentinel;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                pred.next = head.next;
            } else {
                pred = pred.next;
            }
            head = head.next;
        }
        return sentinel.next;
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
            return "Current NODE value: " + val;
        }
    }
}
