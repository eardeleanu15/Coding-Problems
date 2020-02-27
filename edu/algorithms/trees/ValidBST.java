package edu.algorithms.trees;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node’s key.
 * The right subtree of a node contains only nodes with keys greater than the node’s key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Example :
 *
 * Input :
 *    1
 *   /  \
 *  2    3
 *
 * Output : 0 or False
 *
 *
 * Input :
 *   2
 *  / \
 * 1   3
 *
 * Output : 1 or True
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class ValidBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(5);

        System.out.println("Is Valid BST: " + (new ValidBST().isValidBST(root) == 1 ? "yes": "no"));

    }

    public int isValidBST(TreeNode A) {
        return isValidRecursive(A, MIN_VALUE, MAX_VALUE);
    }

    private int isValidRecursive(TreeNode node , int min, int max) {
        if (node == null) {
            return 1;
        }

        if (node.value < max && node.value > min
            && isValidRecursive(node.left, min, node.value) == 1
            && isValidRecursive(node.right, node.value, max) == 1) {
            return 1;
        }
        return 0;
    }

}
