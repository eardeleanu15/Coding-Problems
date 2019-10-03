package edu.algorithms.trees;

import java.util.ArrayList;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 *  Note: You may assume that duplicates do not exist in the tree.
 * Example :
 *
 * Input :
 *         PreOrder : [1, 2, 3]
 *         InOrder  : [2, 1, 3]
 *
 * Return :
 *             1
 *            / \
 *           2   3
 */
public class ConstructBinaryTreeFromInorderAndPreorder {

    static int preIndex = 0;

    public static void main(String[] args) {
        ArrayList<Integer> preOrder = new ArrayList<>();
        preOrder.add(1);
        preOrder.add(2);
        preOrder.add(3);

        ArrayList<Integer> inOrder = new ArrayList<>();
        inOrder.add(2);
        inOrder.add(1);
        inOrder.add(3);
        TreeNode root = new ConstructBinaryTreeFromInorderAndPreorder()
            .buildTree(preOrder, inOrder);
    }

    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (B == null || B.isEmpty()) {
            return null;
        }

        int rootElem = A.get(preIndex++);
        int rootElemPositionInInorder = findRootElemPositionInInorderList(rootElem, B);
        TreeNode root = new TreeNode(rootElem);

        root.left = buildTree(A, new ArrayList<>(B.subList(0, rootElemPositionInInorder)));
        root.right = buildTree(A, new ArrayList<>(B.subList(rootElemPositionInInorder + 1, B.size())));

        return root;
    }


    public int findRootElemPositionInInorderList(Integer rootElem, ArrayList<Integer> inOrder) {
        for(int i = 0; i < inOrder.size(); i++) {
            if (inOrder.get(i).equals(rootElem)) {
                return i;
            }
        }
        return -1;
    }
}
