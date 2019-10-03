package edu.algorithms.trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes’ values.
 */
public class InOrderTraversal {

    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> inorder =  new ArrayList<>();
        if (A == null) {
            return inorder;
        }
        Stack<TreeNode> stack = new Stack();
        TreeNode current = A;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            inorder.add(current.value);
            current = current.right;
        }
        return inorder;
    }
}
