package edu.algorithms.trees;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 *  Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node
 *  never differ by more than 1.
 *
 *  Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 *
 * Example :
 * Input 1 :
 *           1
 *          / \
 *         2   3
 * Return : True or 1
 *
 * Input 2 :
 *          3
 *         /
 *        2
 *       /
 *      1
 * Return : False or 0
 *          Because for the root node, left subtree has depth 2 and right subtree has depth 0.
 */
public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);
        System.out.println("Is Balanced: " + (isBalanced(root) == 1 ? "yes" : "no"));
    }

    public static int isBalanced(TreeNode A) {
        if (A == null) {
            return 0;
        }
        int maxDepthLeftSubTree = maxDepth(A.left);
        int maxDepthRightSubTree = maxDepth(A.right);
        int diff = Math.abs(maxDepthLeftSubTree - maxDepthRightSubTree);
        if (diff == 0 || diff == 1) {
            return 1;
        }
        return 0;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
