package edu.algorithms.linkedlists;

import java.util.Stack;

/**
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);

        ListNode reversedList = reverseList(list);

        while (reversedList != null) {
            System.out.print(reversedList.val + " ");
            reversedList = reversedList.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        ListNode reversed = null;
        ListNode currentReversedNode = null;
        while (!stack.isEmpty()) {
            if (reversed == null) {
                reversed = new ListNode(stack.pop());
                currentReversedNode = reversed;
            } else {
                currentReversedNode.next = new ListNode(stack.pop());
                currentReversedNode = currentReversedNode.next;
            }
        }
        return reversed;
    }
}
