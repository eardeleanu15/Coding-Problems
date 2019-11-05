package edu.algorithms.linkedlists;

/**
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 *     342 + 465 = 807
 * Make sure there are no trailing zeros in the output list
 * So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.
 */
public class AddTwoNumbersAsLists {

    public static void main(String[] args) {
        ListNode A = new ListNode(9);
        A.next = new ListNode(9);
        A.next.next = new ListNode(1);

        ListNode B = new ListNode(1);

        ListNode sum = addTwoNumbers(A, B);
    }

    public static ListNode addTwoNumbers(ListNode A, ListNode B) {
        if (A == null || B == null) {
            return null;
        }
        ListNode head = null;
        ListNode current = null;
        // digit sum is greater or equal to 10
        boolean overflow = false;
        int sum;

        // iterate on common number of digits
        while (A != null && B != null) {
            sum = (overflow ? 1 : 0) + A.val + B.val;
            if (sum >= 10) {
                sum = sum % 10;
                overflow = true;
            } else {
                overflow = false;
            }

            if (head == null) {
                head = new ListNode(sum);
                current = head;
            } else {
                current.next = new ListNode(sum);
                current = current.next;
            }
            A = A.next;
            B = B.next;
        }

        // check if we still have digits in A, if YES iterate until end of A
        if (A != null) {
            while (A != null) {
                if (A.val == 0 && A.next == null) {
                    break;
                } else {
                    sum = (overflow ? 1 : 0) + A.val;
                    if (sum >= 10) {
                        sum = sum % 10;
                        overflow = true;
                    } else {
                        overflow = false;
                    }
                    current.next = new ListNode(sum);
                    current = current.next;
                }
                A = A.next;
            }
        }

        // check if we still have digits in B; if YES iterate until end of B
        if (B != null) {
            while (B != null) {
                if (B.val == 0 && B.next == null) {
                    break;
                } else {
                    sum = (overflow ? 1 : 0) + B.val;
                    if (sum >= 10) {
                        sum = sum % 10;
                        overflow = true;
                    } else {
                        overflow = false;
                    }
                    current.next = new ListNode(sum);
                    current = current.next;
                }
                B = B.next;
            }
        }

        // corner case for extra digit (i.e 999 + 1)
        if (overflow) {
            current.next = new ListNode(1);
        }

        return head;
    }

}
