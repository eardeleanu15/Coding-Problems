package edu.algorithms.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an inorder traversal of a cartesian tree, construct the tree.
 *
 *  Cartesian tree : is a heap ordered binary tree, where the root is greater than all the elements in the subtree.
 *  Note: You may assume that duplicates do not exist in the tree.
 *
 *  Input : [2 1 3]
 *
 * Return :
 *           3
 *          /
 *         2
 *         \
 *          1
 */
public class InorderTraversalOfCartesianTree {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);

        TreeNode root = new InorderTraversalOfCartesianTree().buildTree(list);
    }

    public TreeNode buildTree(List<Integer> A) {
        if (A == null) {
            return null;
        }
        return buildTreeRecursive(A);
    }

    public TreeNode buildTreeRecursive(List<Integer> A) {
        if (A == null || A.isEmpty()) {
            return null;
        }
        int maxElemPosition = findMaxElemPosition(A);
        // construct tree root from max element
        TreeNode root = new TreeNode(A.get(maxElemPosition));
        root.left = buildTreeRecursive(A.subList(0, maxElemPosition));
        root.right = buildTreeRecursive((A.subList(maxElemPosition + 1, A.size())));

        return root;
    }

    public int findMaxElemPosition(List<Integer> A) {
        if (A.size() == 1) {
            return 0;
        }

        // find Max elem
        int maxElem = A.get(0);
        int maxElemPosition = 0;
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) > maxElem) {
                maxElem = A.get(i);
                maxElemPosition = i;
            }
        }
        return maxElemPosition;
    }
}
