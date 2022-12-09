package interview.collection;

// [8,3,10,1,6,null,14,null,null,4,7,13]
public class MaximumDifferenceBetweenNodeAncestor {

    // record the required maximum difference
   static int result = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);

        TreeNode leftSix = new TreeNode(6);
        leftSix.left = new TreeNode(4);
        leftSix.right = new TreeNode(7);

        TreeNode leftThree = new TreeNode(3);
        leftThree.left = new TreeNode(1);
        leftThree.right = leftSix;

        root.left = leftThree;

        TreeNode leftFourteen = new TreeNode(14);
        leftFourteen.left = new TreeNode(13);

        TreeNode leftTen = new TreeNode(10);
        leftTen.right = leftFourteen;

        root.right = leftTen;

        int answer = maxAncestorDiffSecondSolution(root);
        System.out.println("Answer: " + answer);
    }

    // Time complexity: O(N) since we visit all nodes once.
    // Space complexity: O(N) since we need stacks to do recursion
    static int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;

        result = 0;
        helper(root, root.val, root.val);
        return result;
    }


    static void helper(TreeNode node, int curMax, int curMin) {
        if (node == null) return;

        // update `result`
        int possibleResult = Math.max(
                Math.abs(curMax - node.val),
                Math.abs(curMin - node.val)
        );

        result = Math.max(result, possibleResult);
        // update the max and min
        curMax = Math.max(curMax, node.val);
        curMin = Math.min(curMin, node.val);
        helper(node.left, curMax, curMin);
        helper(node.right, curMax, curMin);
    }

    static int maxAncestorDiffSecondSolution(TreeNode root) {
        if (root == null) return 0;
        return helperTwo(root, root.val, root.val);
    }

    static int helperTwo(TreeNode node, int curMax, int curMin) {
        // if encounter leaves, return the max-min along the path
        if (node == null) return curMax - curMin;

        // else, update max and min
        // and return the max of left and right subtrees
        curMax = Math.max(curMax, node.val);
        curMin = Math.min(curMin, node.val);
        int left = helperTwo(node.left, curMax, curMin);
        int right = helperTwo(node.right, curMax, curMin);
        return Math.max(left, right);
    }
}
