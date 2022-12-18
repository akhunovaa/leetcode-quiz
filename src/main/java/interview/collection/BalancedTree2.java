package interview.collection;

public class BalancedTree2 {

    public boolean isBalanced(TreeNode root) {
        // if the tree is empty, we can say it’s balanced...
        if (root == null)  return true;
        // height will return -1, when it’s an unbalanced tree...
        if (height(root) == -1)  return false;
        return true;
    }

    // create a method to return the “height” of a current subtree using recursion...
    public int height(TreeNode root) {
        // base case...
        if (root == null)  return 0;
        // height of left subtree...
        int leftHeight = height(root.left);
        // height of height subtree...
        int rightHeight = height(root.right);
        // in case of left subtree or right subtree unbalanced, return -1...
        if (leftHeight == -1 || rightHeight == -1)  return -1;
        // if their heights differ by more than ‘1’, return -1...
        if (Math.abs(leftHeight - rightHeight) > 1)  return -1;
        // otherwise, return the height of this subtree as max(leftHeight, rightHeight) + 1...
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
