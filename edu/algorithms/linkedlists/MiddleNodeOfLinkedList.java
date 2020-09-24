package edu.algorithms.linkedlists;

/**
 * Given a singly linked list, find middle of the linked list. For example, if given linked list is 1->2->3->4->5 then output should be 3.
 * If there are even nodes, then there would be two middle nodes, we need to print second middle element.
 * For example, if given linked list is 1->2->3->4->5->6 then output should be 4.
 */
public class MiddleNodeOfLinkedList {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);

        System.out.println(middleNode(root));
    }

    public static int middleNode(ListNode head) {
        int result = -1;
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        if (head != null) {
            while (fastPtr != null && fastPtr.next != null) {
                fastPtr = fastPtr.next.next;
                slowPtr = slowPtr.next;
            }
            result = slowPtr.val;
        }
        return result;
    }

}
