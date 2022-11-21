package interview.collection;

/**
 * <b>Validate Binary Search Tree</b>
 * <p></p>
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p></p>
 * <b>Example 1:</b>
 * Input: root = [2,1,3]
 * Output: true
 * <p></p>
 * <b>Example 2:</b>
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);


        boolean answer = isValidBST(root);
        System.out.println("Answer: " + answer);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    public static boolean validate(TreeNode root, Integer low, Integer high) {
        // Empty trees are valid BSTs.
        if (root == null) {
            return true;
        }
        // The current node's value must be between low and high.
        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }
        // The left and right subtree must also be valid.
        return validate(root.right, root.val, high) && validate(root.left, low, root.val);
    }


}
