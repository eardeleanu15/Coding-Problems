package edu.algorithms.linkedlists;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 *  Note:
 * If n is greater than the size of the list, remove the first node of the list.
 */
public class RemoveNthNodeFromListEnd {

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);

        ListNode listAfterRemoval = removeNthFromEnd(list, 1);
    }

    public static ListNode removeNthFromEnd(ListNode A, int B) {
        if (A == null) {
            return null;
        }
        ListNode current = A;
        int listSize = 0;
        while (current != null) {
            listSize++;
            current = current.next;
        }

        if (B > listSize) {
            return A.next;
        }
        int removeNextNodePosition = listSize - B;
        if (removeNextNodePosition == 0) {
            return A.next;
        } else {
            current = A;
            while (removeNextNodePosition > 1) {
                current = current.next;
                removeNextNodePosition--;
            }
            ListNode nextNode = current.next;
            if (nextNode.next != null) {
                current.next = nextNode.next;
            } else {
                current.next = null;
            }
        }
        return A;
    }
}
