package edu.algorithms.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary search tree, write a function to find the kth smallest element in the tree.
 *
 * Example :
 *
 * Input :
 *   2
 *  / \
 * 1   3
 *
 * and k = 2
 *
 * Return : 2
 *
 * As 2 is the second smallest element in the tree.
 *  NOTE : You may assume 1 <= k <= Total number of nodes in BST
 *
 */
public class KthSmallestElement {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(new KthSmallestElement().kthSmallest(root, 2));
    }

    public int kthSmallest(TreeNode A, int B) {
        List<Integer> sortedList = new ArrayList<>();
        inOrderTraversal(A, sortedList);
        return sortedList.get(B - 1);

    }
    public void inOrderTraversal(TreeNode A, List<Integer> list) {
        if (A != null) {
            inOrderTraversal(A.left, list);
            list.add(A.value);
            inOrderTraversal(A.right, list);
        }
    }
}
