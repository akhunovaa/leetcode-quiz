package interview.collection;

/**
 * <b>Intersection of Two Linked Lists</b>
 * <p></p>
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two
 * linked lists have no intersection at all, return null.
 * For example, the following two linked lists begin to intersect at node c1:
 * The test cases are generated such that there are no cycles anywhere in the entire linked structure.
 * Note that the linked lists must retain their original structure after the function returns.
 * <p></p>
 * <b>Custom Judge</b>:
 * The inputs to the judge are given as follows (your program is not given these inputs):
 * intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
 * listA - The first linked list.
 * listB - The second linked list.
 * skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
 * skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
 * The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program.
 * If you correctly return the intersected node, then your solution will be accepted.
 */
public class IntersectionTwoLinkedLists {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode headA = new ListNode(4, new ListNode(1, listNode));
        ListNode headB = new ListNode(1, new ListNode(5, new ListNode(6, new ListNode(1, listNode))));
        ListNode answer = getIntersectionNode(headA, headB);
        while (answer != null) {
            System.out.println("Answer: " + answer);
            answer = answer.next;
        }
    }

    // Time Complexity: O(A + B) where A and B are the lengths of each linked list.
    // Space Complexity: O(1)
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptrA = headA, ptrB = headB;
        while (ptrA != ptrB) { // loop until we found the first common node
            ptrA = ptrA == null ? headB : ptrA.next; // once we're done with A, move to B
            ptrB = ptrB == null ? headA : ptrB.next; // once we're done with B, move to A
        }
        return ptrA;
    }
}
