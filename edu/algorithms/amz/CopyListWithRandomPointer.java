package edu.algorithms.amz;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 * The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 *
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
 */
public class CopyListWithRandomPointer {

    private Map<Node, Node> visited = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node oldNode = head;
        Node newNode = new Node(oldNode.val);
        this.visited.put(oldNode, newNode);

        while (oldNode != null) {
            newNode.random = this.getClonnedNode(oldNode.random);
            newNode.next = this.getClonnedNode(oldNode.next);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return this.visited.get(head);
    }

    public Node getClonnedNode(Node initialNode) {
        if (initialNode != null) {
            if (!this.visited.containsKey(initialNode)) {
                this.visited.put(initialNode, new Node(initialNode.val));
            }
            return this.visited.get(initialNode);
        }
        return null;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
