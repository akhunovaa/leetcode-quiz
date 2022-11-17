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
        // ListNode answer = rotateRight(head, k);
        ListNode answer = reverseList(head);
        while (answer != null) {
            System.out.println("Answer: " + answer);
            answer = answer.next;
        }

    }

    static ListNode reverseList(ListNode head) {
        // граничный случай
        // больше необходим для рекрсивного вызова для понимания границы последнего элемента
        if (head == null || head.next == null) {
            return head;
        }
        // при помощи рекурсии доходим до последнего элемента в списке и устанавливаем его на переменную res => [value: 5]
        ListNode res = reverseList(head.next);
        // head при рекурсивном последнем вызове будет иметь значение head = [value: 4]
        // значение у head.next будет висеть head.next = [value: 4]
        // где head.next.next понятное дело будет null (так как у head.next со значением [value: 5] является последним элементом в списке
        // его то и нужно установить на head со значением [value: 4] чтобы от [value: 5] => next был [value: 4]
        head.next.next = head;
        // и head.next устанавливаем в null чтобы у [value: 4] next значения не было: [value: 5] => [value: 4] => null
        head.next = null;
        // возвращаем предыдущему рекурсивному вызову сформированный список res = [value: 5] => [value: 4]
        return res;
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
