package edu.algorithms.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement an iterator over a binary search tree (BST).
 * Your iterator will be initialized with the root node of a BST.
 *
 * The first call to next() will return the smallest number in BST.
 * Calling next() again will return the next smallest number in the BST, and so on.
 */
public class BSTIterator {

    private final Queue<Integer> sortedQueue = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        inOrderTraversal(root, sortedQueue);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (sortedQueue.peek() != null) {
            return true;
        }
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        return sortedQueue.poll();
    }

    public void inOrderTraversal(TreeNode root, Queue<Integer> list) {
        if (root != null) {
            inOrderTraversal(root.left, list);
            list.add(root.value);
            inOrderTraversal(root.right, list);
        }
    }

}
