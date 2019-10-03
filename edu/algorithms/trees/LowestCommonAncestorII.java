package edu.algorithms.trees;

/**
 * Given a binary tree and two values say n1 and n2, write a program to find the least common ancestor.
 *
 * You can assume that the nodes are always present in the tree.
 */
public class LowestCommonAncestorII {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        System.out.println("Lowest Common Ancestor of 4 and 5 is: " +
            new LowestCommonAncestorII().lca(tree, 4, 5).value);
    }

    /**
     * The idea is to traverse the tree starting from root. If any of the given keys (n1 and n2) matches with root,
     * then root is LCA (assuming that both keys are present).
     * If root doesn’t match with any of the keys, we recur for left and right subtree.
     * The node which has one key present in its left subtree and the other key present in right subtree is the LCA.
     * If both keys lie in left subtree, then left subtree has LCA also, otherwise LCA lies in right subtree.
     */
    public TreeNode lca(TreeNode root, int n1, int n2) {
        if (root == null) {
            return null;
        }

        if (root.value == n1 || root.value == n2) {
            return root;
        }

        TreeNode leftNode = lca(root.left, n1, n2);
        TreeNode rightNode = lca(root.right, n1, n2);

        if (leftNode != null && rightNode != null) {
            return root;
        }
        return (leftNode != null) ? leftNode : rightNode;
    }

}
