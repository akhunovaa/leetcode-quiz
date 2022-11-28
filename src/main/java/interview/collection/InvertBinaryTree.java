package interview.collection;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode answer = iterativeTreeInvert(root);
        System.out.println("Answer: " + answer);
    }

    public static TreeNode recursiveTreeInvert(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = recursiveTreeInvert(root.right);
        TreeNode left = recursiveTreeInvert(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

    public static TreeNode iterativeTreeInvert(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }

}
