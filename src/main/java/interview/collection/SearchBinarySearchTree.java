package interview.collection;

import java.util.Stack;

public class SearchBinarySearchTree {

    // Time Complexity: O(log n) or O(h)
    // Space Complexity: O(h)
    // n -> number of nodes in the tree
    // h -> height of the tree
    public TreeNode stackUsingSearchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        if (root.val > val) {
            stack.push(root.left);
        } else {
            stack.push(root.right);
        }
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            if (currentNode != null) {
                if (currentNode.val == val) {
                    return currentNode;
                }
                if (currentNode.val > val) {
                    stack.push(currentNode.left);
                } else {
                    stack.push(currentNode.right);
                }
            }
        }
        return null;
    }

    // Time Complexity: O(log n) or O(h)
    // Space Complexity: O(h)
    // n -> number of nodes in the tree
    // h -> height of the tree
    public TreeNode recursiveUsingSearchBST(TreeNode root, int val) {
        if (root == null) return root;
        if (val < root.val) return recursiveUsingSearchBST(root.left, val);
        if (val > root.val) return recursiveUsingSearchBST(root.right, val);
        return root;
    }

    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    public TreeNode iterativeUsingSearchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = val < root.val ? root.left : root.right;
        }

        return root;
    }
}
