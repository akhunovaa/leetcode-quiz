package interview.collection;

/**
 * <b>Maximum Depth of Binary Tree</b>
 * <p></p>
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p></p>
 * <b>Example 1:</b>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * <p></p>
 * <b>Example 2:</b>
 * Input: root = [1,null,2]
 * Output: 2
 */
public class MaximumDepthBinaryTree {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);

        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(9);

        root.setLeft(nine);
        root.setRight(twenty);

        twenty.setLeft(fifteen);
        twenty.setRight(seven);

        int answer = maxDepth(root);
        System.out.println("Answer: " + answer);
    }

    public static int maxDepth(TreeNode root) {
        // Base Condition
        if(root == null) return 0;
        // Hypothesis
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // Induction
        return Math.max(left, right) + 1;
    }
}
