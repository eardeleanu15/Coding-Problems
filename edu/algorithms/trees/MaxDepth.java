package edu.algorithms.trees;

/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth of a binary tree is the number of nodes along the longest path from the root node down to the
 * farthest leaf node.
 *
 *  NOTE : The path has to end on a leaf node.
 */
public class MaxDepth {

    public int maxDepth(TreeNode A) {
        if (A == null) {
            return 0;
        }
        return Math.max(maxDepth(A.left), maxDepth(A.right)) + 1;
    }

}
