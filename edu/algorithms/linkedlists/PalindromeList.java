package edu.algorithms.linkedlists;

import java.util.Stack;

/**
 * Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.
 *
 * Notes:
 * Expected solution is linear in time and constant in space.
 * For example,
 *
 * List 1-->2-->1 is a palindrome.
 * List 1-->2-->3 is not a palindrome.
 */
public class PalindromeList {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(1);

        System.out.println("Is palindrome list: " + (new PalindromeList().lPalin(root) == 1 ? "yes":"no"));
    }

    public int lPalin(ListNode A) {
        if (A == null) {
            return 0;
        }

        // construct stack
        Stack<Integer> stack = new Stack<>();
        ListNode current = A;
        while(current != null) {
            stack.push(current.val);
            current = current.next;
        }

        // iterate through stack and list
        current = A;
        while(current != null) {
            int stackValue = (int) stack.pop();
            if (current.val != stackValue) {
                return 0;
            }
            current = current.next;
        }

        return 1;
    }

}
