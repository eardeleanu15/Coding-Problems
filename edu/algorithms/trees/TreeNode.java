package edu.algorithms.trees;

// Class defining each node with some value and its children
public class TreeNode {
    public int value;
    public TreeNode left, right;

    public TreeNode(int item) {
        value = item;
        left = right = null;
    }
}
