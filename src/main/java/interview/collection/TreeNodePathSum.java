package interview.collection;

public class TreeNodePathSum {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.right = new TreeNode(2);

        boolean answer = hasPathSum(root, 22);
        System.out.println("Answer: " + answer);
    }

    // Input: root = [1,2,3], targetSum = 5
    // Output: false
    // Explanation: There two root-to-leaf paths in the tree:
    // (1 --> 2): The sum is 3.
    // (1 --> 3): The sum is 4.
    // There is no root-to-leaf path with sum = 5.

    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        // return false if the root is null
        if(root == null) return false;
        // if it reaches to the end and the val is equal to the sum, return true
        if(root.left == null && root.right == null && root.val == targetSum) return true;
        // otherwise, we traverse left node and right node with the new targetSum `targetSum - root.val`
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }


}
