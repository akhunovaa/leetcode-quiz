package interview.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <b>N-ary Tree Preorder Traversal</b>
 * <p></p>
 * Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
 * Nary-Tree input serialization is represented in their level order traversal. Each group of
 * children is separated by the null value (See examples)
 * <p></p>
 * <b>Example 1</b>:
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [1,3,5,6,2,4]
 * <p></p>
 * <b>Example 2</b>:
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 */
public class TreePreorderTraversal {

    public static void main(String[] args) {
        List<Node> children = new ArrayList<>();

        Node two = new Node(2);
        Node five = new Node(5);
        Node six = new Node(6);

        List<Node> children3 = new ArrayList<>();
        children3.add(five);
        children3.add(six);

        Node three = new Node(3, children3);
        Node four = new Node(4);
        children.add(two);
        children.add(three);
        children.add(four);

        Node root = new Node(1, children);

        List<Integer> answer = preorder(root);
        System.out.println("Answer: " + answer);
    }

    static List<Integer> result = new ArrayList<>();

    // способ обойти элементы дерева рекурсивно
    static List<Integer> preorder(Node root) {
        if (root == null) return result;
        result.add(root.val);

        for (Node child : root.children) {
            preorder(child);
        }
        return result;
    }

    // способ обойти элементы дерева итеративно с применением Stack<Node>
    static List<Integer> preorderStack(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<Node> toVisit = new Stack<>();
        toVisit.push(root);

        while (!toVisit.isEmpty()) {
            Node visited = toVisit.pop();
            result.add(visited.val);
            if (visited.children != null) {
                for (int i = visited.children.size() - 1; i >= 0; i--) {
                    toVisit.push(visited.children.get(i));
                }
            }
        }
        return result;
    }

}
