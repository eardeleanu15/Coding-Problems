package edu.algorithms.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(11);
        bst.insert(2);
        bst.insert(9);
        bst.insert(13);
        bst.insert(57);
        bst.insert(25);
        bst.insert(1);
        bst.insert(90);
        bst.insert(3);

        System.out.println("InOrder Traversal");
        bst.inOrder();

        System.out.println("\nPreOrder Traversal");
        bst.preOrder();

        System.out.println("\nPostOrder Traversal");
        bst.postOrder();

        System.out.println("\nBreathFirstSearch Traversal");
        bst.breathFirstSearchTraversal();

        System.out.println("\nIs element 91 present in BST: " + (bst.search(91) ? "true" : "false"));
        System.out.println("Is element 57 present in BST: " + (bst.search(57) ? "true" : "false"));
        System.out.println("Is element 13 present in BST: " + (bst.search(13) ? "true" : "false"));

        System.out.println("Min elem in BST is: " + bst.getMinElement());
        System.out.println("Max elem in BST is: " + bst.getMaxElement());

    }

    TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int x) {
        root = insertRecursive(root, x);
    }

    private TreeNode insertRecursive(TreeNode root, int x) {
        if (root == null) {
            root = new TreeNode(x);
        } else if (x < root.value ) {
            root.left = insertRecursive(root.left, x);
        } else {
            root.right = insertRecursive(root.right, x);
        }
        return root;
    }

    public void inOrder() {
        inOrderRecursive(root);
    }

    // left - root - right
    private void inOrderRecursive(TreeNode root) {
        if (root != null) {
            inOrderRecursive(root.left);
            System.out.print(root.value + " ");
            inOrderRecursive(root.right);
        }
    }

    public void preOrder() {
        preOrderRecursive(root);
    }

    // root - left - right
    private void preOrderRecursive(TreeNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrderRecursive(root.left);
            preOrderRecursive(root.right);
        }
    }

    public void postOrder() {
        postOrderRecursive(root);
    }

    // left - right - root
    public void postOrderRecursive(TreeNode root) {
        if (root != null) {
            postOrderRecursive(root.left);
            postOrderRecursive(root.right);
            System.out.print(root.value + " ");
        }
    }

    public void breathFirstSearchTraversal() {
        Queue<TreeNode> queue = new LinkedList<>();

        // add root
        queue.add(root);
        while (!queue.isEmpty()) {
            // extract value from queue
            TreeNode node = queue.poll();
            System.out.print(node.value + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public boolean search(int x) {
        return searchRecursive(root, x);
    }

    private boolean searchRecursive(TreeNode root, int x) {
        if (root == null) {
            return false;
        } else if (root.value == x) {
            return true;
        } else if (x < root.value) {
            return searchRecursive(root.left, x);
        } else {
            return  searchRecursive(root.right, x);
        }
    }

    public int getMinElement() {
        TreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    public int getMaxElement() {
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }
}
