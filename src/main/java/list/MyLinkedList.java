package list;

public class MyLinkedList {

    int size = 0;
    Node first;
    Node last;


    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
     public Integer get(int index) {
         if (index < 0 || index >= size ){
             return -1;
         }
        Node node = node(index);

        return null != node ? node.item : null;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(Integer val) {
        linkFirst(val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(Integer val) {
        linkLast(val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, Integer val) {
        if (index == size)
            linkLast(val);
        else
            linkBefore(val, node(index));
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size ){
            return;
        }
        Node node = node(index);
        if (null != node){
            unlink(node);
        }
    }

    void unlink(Node x) {
        final Node next = x.next;
        final Node prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
    }

    void linkBefore(Integer value, Node succ) {
        final Node pred = succ.prev;
        final Node newNode = new Node(pred, value, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
    }


    private void linkFirst(Integer val) {
        final Node f = first;
        final Node newNode = new Node(null, val, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }

    void linkLast(Integer val) {
        final Node l = last;
        final Node newNode = new Node(l, val, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    Node node(int index) {
        Node x;
        if (index < (size >> 1)) {
            x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        }
        else {
            x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
        };
        return x;
    }

    private static class Node {
        Integer item;
        Node next;
        Node prev;

        Node(Node prev, Integer element, Node next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

}
