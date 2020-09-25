package edu.algorithms.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> levelOrderTraversal = levelOrder(root);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int h = height(root);
        for (int i = 1; i <= h; i++) {
            List<Integer> printedLevel = new ArrayList<>();
            printLevelOrder(root, i, printedLevel);
            result.add(printedLevel);
        }
        return result;
    }

    public static void printLevelOrder(TreeNode node, int level, List<Integer> printedLevel) {
        if (node == null) {
            return;
        }
        if (level == 1) {
            printedLevel.add(node.value);
        } else if (level > 1) {
            printLevelOrder(node.left, level - 1, printedLevel);
            printLevelOrder(node.right, level - 1, printedLevel);
        }
    }

    public static int height(TreeNode A) {
        if (A == null) {
            return 0;
        }
        return Math.max(height(A.left), height(A.right)) + 1;
    }

}
