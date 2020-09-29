package edu.algorithms.linkedlists;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * Try solving it using constant additional space.
 *
 * Example :
 *
 * Input :
 *
 *                   ______
 *                  |     |
 *                  \/    |
 *         1 -> 2 -> 3 -> 4
 *
 * Return the node corresponding to node 3.
 */
public class ListCycle {

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        ListNode cycleNode = list.next.next;

        list.next.next.next = new ListNode(4);
        list.next.next.next.next = cycleNode;

        ListNode cycleDetectedByHashing = new ListCycle().detectCycleByHashing(list);
        System.out.println("Cycle detected by hashing: " + (cycleDetectedByHashing != null ? ("true" + ", value: " + cycleDetectedByHashing.val) : "false"));

        ListNode cycleDetected = new ListCycle().detectCycle(list);
        System.out.println("Cycle detected by Floyd’s Cycle-Finding Algorithm: " +
            (cycleDetected != null ? ("true" + ", value: " + cycleDetected.val) : "false"));
    }

    /**
     * Use Hashing
     * Time complexity - O(N) && Space complexity - O(N)
     */
    public ListNode detectCycleByHashing(ListNode a) {
        Set<Integer> visited = new HashSet<>();
        ListNode current = a;
        while (current != null) {
            if (visited.contains(current.val)) {
                return current;
            } else {
                visited.add(current.val);
            }

            current = current.next;
        }
        return null;
    }

    /**
     * Floyd’s Cycle-Finding Algorithm: This is the fastest method and has been described below:
     *
     * Traverse linked list using two pointers.
     * Move one pointer(slow_p) by one and another pointer(fast_p) by two.
     * If these pointers meet at the same node then there is a loop.
     * If pointers do not meet then linked list doesn’t have a loop
     *
     * Time complexity - O(N)
     */
    public ListNode detectCycle(ListNode a) {
        ListNode slow = a;
        ListNode fast = a;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // cycle detected
                return slow;
            }
        }
        return null;
    }

    /**
     * Floyd's Cycle-Finding Algorithm impl 2
     */
    public boolean hasCycle(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        boolean hasCycle = false;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (fastPtr == slowPtr) {
                hasCycle = true;
                break;
            }
        }

        return hasCycle;
    }
}
