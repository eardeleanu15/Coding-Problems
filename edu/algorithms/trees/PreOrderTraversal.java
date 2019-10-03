package edu.algorithms.trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the pre-order traversal of its nodes’ values.
 */
public class PreOrderTraversal {

    public ArrayList<Integer> traverse(TreeNode A) {
        ArrayList<Integer> preOrder = new ArrayList<>();
        if (A == null) {
            return preOrder;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = A;
        stack.push(current);
        while (!stack.isEmpty()) {
            current = stack.pop();
            preOrder.add(current.value);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return preOrder;
    }
}
