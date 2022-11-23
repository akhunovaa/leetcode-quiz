package interview.collection;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <b>Populating Next Right Pointers in Each Node</b>
 * <p></p>
 * You are given a perfect binary tree where all leaves are on the same level, and
 * every parent has two children.The binary tree has the following definition:
 * <p></p>
 * <pre>
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * </pre>
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * <p></p>
 * <b>Example 1:</b>
 * <b>Input:</b> root = [1,2,3,4,5,6,7]
 * <b>Output:</b> [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node,
 * just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 * <p></p>
 * <b>Example 2:</b>
 * <b>Input:</b> root = []
 * Output: []
 */
public class PopulatingNextRightPointersEachNode {

    public static void main(String[] args) {

        Node root = new PopulatingNextRightPointersEachNode.Node(1);

        Node rootLeft = new PopulatingNextRightPointersEachNode.Node(2);
        rootLeft.left = new PopulatingNextRightPointersEachNode.Node(4);
        rootLeft.right = new PopulatingNextRightPointersEachNode.Node(5);

        Node rootRight = new PopulatingNextRightPointersEachNode.Node(3);
        rootRight.left = new PopulatingNextRightPointersEachNode.Node(6);
        rootRight.right = new PopulatingNextRightPointersEachNode.Node(7);

        root.left = rootLeft;
        root.right = rootRight;

        Node answer = queueConnectBFS(root);

        while (answer.next != null) {
            System.out.println("Answer: " + answer);
            answer = answer.next;
        }
    }

    // BFS Solution - Right to Left
    // BFS - Breadth First Search - поиск в ширину
    public static Node queueConnectBFS(Node root) {
        if (root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node rightNode = null;
            for (int i = q.size(); i > 0; i--) {
                Node cur = q.poll();
                cur.next = rightNode;
                rightNode = cur;
                if (cur.right != null) {
                    q.offer(cur.right);
                    q.offer(cur.left);
                }
            }
        }
        return root;
    }

    // DFS Solution - Depth First Traversals
    // DFS - Depth First Search - поиск в ширину
    public static Node connectDFS(Node root) {
        if (root == null) return null;
        Node L = root.left, R = root.right, N = root.next;
        if (L != null) {
            L.next = R;
            if (N != null) R.next = N.left;
            connectDFS(L);
            connectDFS(R);
        }
        return root;
    }

    // BFS Solution - Space-Optimized Appraoch
    // BFS - Breadth First Search - поиск в ширину - оптимизированный по пространству подход
    public static Node spaceOptimisedConnectBFS(Node root) {
        Node head = root;
        for (; root != null; root = root.left) {
            for (Node cur = root; cur != null; cur = cur.next) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                    if (cur.next != null) cur.right.next = cur.next.left;
                } else break;
            }
        }
        return head;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        @Override
        public String toString() {
            return "[value: " + val + "]";
        }
    }

}
