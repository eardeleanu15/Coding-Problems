package edu.algorithms.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and two values say n1 and n2, write a program to find the least common ancestor.
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println("Lowest Common Ancestor of 4 and 5 is: " +
            new LowestCommonAncestor().lca(root, 4, 5));
    }

    /**
     * Following is simple O(n) algorithm to find LCA of n1 and n2.
     * 1) Find path from root to n1 and store it in a vector or array.
     * 2) Find path from root to n2 and store it in another vector or array.
     * 3) Traverse both paths till the values in arrays are same. Return the common element just before the mismatch.
     */
    public int lca(TreeNode root, int n1, int n2) {
        if (root == null) {
            return -1;
        }
        List<Integer> pathN1 = new ArrayList<>();
        List<Integer> pathN2 = new ArrayList<>();
        boolean isN1Found = findPath(root, n1, pathN1);
        boolean isN2Found = findPath(root, n2, pathN2);
        if (!isN1Found) {
            System.out.println("Missing variable from tree: " + n1);
        }
        if (!isN2Found) {
            System.out.println("Missing variable from tree: " + n2);
        }

        // iterate through paths until the nodes differ
        for (int i = 0; i < pathN1.size() && i < pathN2.size(); i++) {
            if (!pathN1.get(i).equals(pathN2.get(i))) {
                return pathN1.get(i - 1);
            }
        }
        return -1;
    }

    public boolean findPath(TreeNode root, int n, List<Integer> path) {
        if (root == null) {
            return false;
        }

        // add root to path
        path.add(root.value);

        if (root.value == n) {
            return true;
        }

        if (root.left != null && findPath(root.left, n, path)) {
            return true;
        }

        if (root.right != null && findPath(root.right, n, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

}
