package edu.algorithms.trees;

/**
 * Given values of two values n1 and n2 in a Binary Search Tree, find the Lowest Common Ancestor (LCA).
 * You may assume that both the values exist in the tree.
 */
public class LowestCommonAncestorBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        System.out.println("Lowest Common Ancestor of 8 and 14 is: " +
            new LowestCommonAncestorBST().lca(root, 8, 14));
    }

    /**
     * We can solve this problem using BST properties. We can recursively traverse the BST from root.
     * The main idea of the solution is, while traversing from top to bottom, the first node n we encounter with
     * value between n1 and n2, i.e., n1 < n < n2 or same as one of the n1 or n2, is LCA of n1 and n2
     * (assuming that n1 < n2).
     * So just recursively traverse the BST in, if node’s value is greater than both n1 and n2 then our LCA lies
     * in left side of the node, if it’s is smaller than both n1 and n2, then LCA lies on right side.
     * Otherwise root is LCA (assuming that both n1 and n2 are present in BST)
     */
    public int lca(TreeNode root, int n1, int n2) {
        if (root == null) {
            return -1;
        }

        if (root.value > n1 && root.value > n2) {
            return lca(root.left, n1, n2);
        }

        if (root.value < n1 && root.value < n2) {
            return lca(root.right, n1, n2);
        }

        return root.value;
    }
}
