package interview.collection;

public class DiameterBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        // Base Condition
        if(root == null) return 0;
        // Hypothesis
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        int current = height(root.left) + height(root.right);
        // Induction
        return Math.max(current, Math.max(left, right));
    }

    int height(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
