package edu.algorithms.amz;

import edu.algorithms.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class ZigZagLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        List<List<Integer>> zigZag = zigzagLevelOrder(node);
        for (List<Integer> level : zigZag) {
            for (Integer i : level) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigZag = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> current = new Stack<>();
            Stack<TreeNode> nextLevel = new Stack<>();
            boolean leftToRight = true;

            current.push(root);
            while (!current.isEmpty()) {
                List<Integer> currentLevel = new ArrayList<>();
                while (!current.isEmpty()) {
                    TreeNode node = current.pop();
                    currentLevel.add(node.value);
                    if (leftToRight) {
                        if (node.left != null) {
                            nextLevel.push(node.left);
                        }
                        if (node.right != null) {
                            nextLevel.push(node.right);
                        }
                    } else {
                        if (node.right != null) {
                            nextLevel.push(node.right);
                        }
                        if (node.left != null) {
                            nextLevel.push(node.left);
                        }
                    }
                }
                zigZag.add(currentLevel);

                // swap Stacks
                Stack<TreeNode> temp = current;
                current = nextLevel;
                nextLevel = temp;

                // switch traversal
                leftToRight = !leftToRight;
            }
        }

        return zigZag;

    }
}
