package edu.algorithms.linkedlists;

/**
 * Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list,
 * instead you will be given access to the node to be deleted directly.
 *
 * It is guaranteed that the node to be deleted is not a tail node in the list.
 *
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
 */
public class DeleteNode {

    public static void main (String[] args) {
        ListNode list = new ListNode(4);
        ListNode toDelete = new ListNode(5);
        list.next = toDelete;
        list.next.next = new ListNode(1);
        list.next.next.next = new ListNode(9);

        deleteNode(toDelete);

        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
    }

    public static void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
    }

}
