package edu.algorithms.trees;

import java.util.ArrayList;
import java.util.List;

/**
 *  Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 *  A height balanced BST : a height-balanced binary tree is defined as a binary tree in which the depth of the two
 *  subtrees of every node never differ by more than 1.
 *
 *  Example :
 * Given A : 1 -> 2 -> 3
 * A height balanced BST  :
 *
 *       2
 *     /   \
 *    1     3
 *
 */
public class ConvertSortedListToBST {

    public static void main(String[] args) {
        List<Integer> sortedList = new ArrayList<>();
        sortedList.add(1);
        sortedList.add(2);
        sortedList.add(3);
        sortedList.add(4);
        sortedList.add(5);
        sortedList.add(6);
        sortedList.add(7);
        TreeNode root = new ConvertSortedListToBST().sortedListToBST(sortedList);
    }

    public TreeNode sortedListToBST(List<Integer> sortedList) {
        return constructBST(sortedList, 0, sortedList.size() - 1);
    }

    private TreeNode constructBST(List<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        int med = start + ((end-start) / 2);
        TreeNode root = new TreeNode(list.get(med));
        root.left = constructBST(list, start, med -1);
        root.right = constructBST(list, med+1, end);
        return root;
    }

}
