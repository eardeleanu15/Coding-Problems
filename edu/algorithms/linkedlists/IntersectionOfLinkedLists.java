package edu.algorithms.linkedlists;

import java.util.Stack;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * For example, the following two linked lists:
 *
 *
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 *
 * begin to intersect at node c1.
 */
public class IntersectionOfLinkedLists {

    public static void main(String[] args) {

        ListNode A = new ListNode(1);
        A.next = new ListNode(3);
        A.next.next = new ListNode(5);
        A.next.next = new ListNode(2);
        A.next.next.next = new ListNode(3);

        ListNode B = new ListNode(3);
        B.next = new ListNode(5);
        B.next.next = new ListNode(2);
        B.next.next = new ListNode(3);

        ListNode intersectionNode = new IntersectionOfLinkedLists().getIntersectionNode(A, B);
        if (intersectionNode == null) {
            System.out.println("No intersection node");
        } else {
            System.out.println("Intersection Node value is : " + intersectionNode.val);
        }
    }

    public ListNode getIntersectionNode(ListNode A, ListNode B) {
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();

        while (A != null) {
            stackA.push(A);
            A = A.next;
        }

        while (B != null) {
            stackB.push(B);
            B = B.next;
        }

        ListNode firstCommonNode = null;
        while (!stackA.isEmpty() || !stackB.isEmpty()) {
            ListNode currentA = stackA.pop();
            ListNode currentB = stackB.pop();
            if (currentA.val == currentB.val) {
                firstCommonNode = currentA;
            } else {
                // values diverge
                break;
            }
        }

        return firstCommonNode;
    }

}
