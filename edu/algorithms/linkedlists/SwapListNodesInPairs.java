package edu.algorithms.linkedlists;

import java.util.Stack;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 */
public class SwapListNodesInPairs {

    public static void main(String[] args) {
        ListNode head = new ListNode(28);
        head.next = new ListNode(34);
        head.next.next = new ListNode(48);
        head.next.next.next = new ListNode(74);
        head.next.next.next.next = new ListNode(42);

        ListNode newHead = swapPairs(head);
        pairWiseSwap(head);
    }

    // O(n) time complexity
    public static ListNode swapPairs(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }

        ListNode head = null;
        ListNode current= null;
        int count = 0;
        Stack<ListNode> stack = new Stack<>();

        while(A != null) {
            // push current node in stack
            stack.push(A);
            if (count % 2 == 1) {
                while (!stack.isEmpty()) {
                    // pop nodes from stack while stack is not empty
                    if (head == null) {
                        head = new ListNode(stack.pop().val);
                        current = head;
                    } else {
                        current.next = new ListNode(stack.pop().val);
                        current = current.next;
                    }
                }
            } else if (A.next == null) {
                // we've reached the list tail
                current.next = new ListNode(stack.pop().val);
                break;
            }
            count++;
            A = A.next;
        }

        return head;
    }

    // O(n) time complexity
    public static void pairWiseSwap(ListNode A) {
        // change only the values of the list nodes and not the pointers
        ListNode temp = A;
        while (temp != null && temp.next != null) {
            int k = temp.val;
            temp.val = temp.next.val;
            temp.next.val = k;
            temp = temp.next.next;
        }
    }

}
