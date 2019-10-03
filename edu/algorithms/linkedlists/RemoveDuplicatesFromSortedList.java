package edu.algorithms.linkedlists;

public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(3);

        deleteDuplicates(root);
    }

    public static ListNode deleteDuplicates(ListNode A) {
        if (A == null) {
            return null;
        }
        ListNode current = A;
        while (current.next != null) {
            ListNode nextNode = current.next;
            if (current.val != nextNode.val) {
                current=nextNode;
            } else {
                while(current.val == nextNode.val) {
                    if (nextNode.next == null) {
                        nextNode = null;
                        break;
                    } else {
                        nextNode = nextNode.next;
                    }
                }
                current.next = nextNode;
                if (nextNode != null) {
                    current = nextNode;
                }
            }
        }
        return A;
    }
}
