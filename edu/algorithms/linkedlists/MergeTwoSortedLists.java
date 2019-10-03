package edu.algorithms.linkedlists;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.
 *
 * For example, given following linked lists :
 *
 *   5 -> 8 -> 20
 *   4 -> 11 -> 15
 * The merged list should be :
 *
 * 4 -> 5 -> 8 -> 11 -> 15 -> 20
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode merged = null;
        ListNode currentMergedNode = null;

        while (A != null && B != null) {
            if (A.val < B.val) {
                if (merged == null) {
                    merged = new ListNode(A.val);
                    currentMergedNode = merged;
                } else {
                    ListNode nextMergedNode = new ListNode(A.val);
                    currentMergedNode.next = nextMergedNode;
                    currentMergedNode = nextMergedNode;
                }
                A = A.next;
            } else {
                if (merged == null) {
                    merged = new ListNode(B.val);
                    currentMergedNode = merged;
                } else {
                    ListNode nextMergedNode = new ListNode(B.val);
                    currentMergedNode.next = nextMergedNode;
                    currentMergedNode = nextMergedNode;
                }
                B = B.next;
            }
        }

        if (A != null ) {
            while (A != null) {
                if (merged == null) {
                    merged = new ListNode(A.val);
                    currentMergedNode = merged;
                } else {
                    ListNode nextMergedNode = new ListNode(A.val);
                    currentMergedNode.next = nextMergedNode;
                    currentMergedNode = nextMergedNode;
                }
                A = A.next;
            }
        }

        if (B != null) {
            while (B != null) {
                if (merged == null) {
                    merged = new ListNode(B.val);
                    currentMergedNode = merged;
                } else {
                    ListNode nextMergedNode = new ListNode(B.val);
                    currentMergedNode.next = nextMergedNode;
                    currentMergedNode = nextMergedNode;
                }
                B = B.next;
            }
        }

        return merged;
    }


}
