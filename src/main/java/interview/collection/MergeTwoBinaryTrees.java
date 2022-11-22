package interview.collection;

import java.util.Stack;

/**
 * <b>Merge Two Binary Trees</b>
 * <p></p>
 * You are given two binary trees root1 and root2.
 * Imagine that when you put one of them to cover the other, some nodes of the two trees are
 * overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that
 * if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise,
 * the NOT null node will be used as the node of the new tree.
 * <p></p>
 * Return the merged tree.
 * <p></p>
 * <b>Note:</b> The merging process must start from the root nodes of both trees.
 * <p></p>
 * <b>Example 1:</b>
 * Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * Output: [3,4,5,5,4,null,7]
 * <p></p>
 * <b>Example 2:</b>
 * Input: root1 = [1], root2 = [1,2]
 * Output: [2,2]
 */
public class MergeTwoBinaryTrees {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.left.right = new TreeNode(4);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(7);

        TreeNode answer = mergeTreesRecursively(root, root2);
        System.out.println("Answer: " + answer);
        answer = mergeTreesStack(root, root2);
        System.out.println("Answer: " + answer);

    }

    public static TreeNode mergeTreesRecursively(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;
        root1.val += root2.val;
        root1.left = mergeTreesRecursively(root1.left, root2.left);
        root1.right = mergeTreesRecursively(root1.right, root2.right);
        return root1;
    }

    public static TreeNode mergeTreesStack(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;

        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{t1, t2});

        while (!stack.isEmpty()) {
            TreeNode[] t = stack.pop();

            if (t[0] == null || t[1] == null) {
                continue;
            }

            t[0].val += t[1].val;
            if (t[0].left == null) {
                t[0].left = t[1].left;
            } else {
                stack.push(new TreeNode[]{t[0].left, t[1].left});
            }
            if (t[0].right == null) {
                t[0].right = t[1].right;
            } else {
                stack.push(new TreeNode[]{t[0].right, t[1].right});
            }
        }
        return t1;
    }

}
