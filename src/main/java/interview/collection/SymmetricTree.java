package interview.collection;

import java.util.Stack;

/**
 * <b>Symmetric Tree</b>
 * <p></p>
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * <p></p>
 * <b>Example 1:</b>
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * <p></p>
 * <b>Example 2:</b>
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 */
public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode leaf = new TreeNode(2);
        leaf.left = new TreeNode(3);
        leaf.right = new TreeNode(4);

        root.setLeft(leaf);
        root.setRight(leaf);

        boolean answer = isSymmetric(root);
        System.out.println("Answer: " + answer);
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        while (!stack.isEmpty()) {
            TreeNode n1 = stack.pop();
            TreeNode n2 = stack.pop();

            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null || n1.val != n2.val) return false;

            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }
        return true;
    }


}
