package edu.algorithms.array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Find the kth smallest element in an unsorted array of non-negative integers.
 *
 * Definition of kth smallest element
 *
 *  kth smallest element is the minimum possible n such that there are at least k elements in the array <= n.
 * In other words, if the array A was sorted, then A[k - 1] ( k is 1 based, while the arrays are 0 based )
 *
 * Example:
 *
 * A : [2 1 4 3 2]
 * k : 3
 *
 * answer : 2
 */
public class KthSmallestElement {

    public static void main(String[] args) {
        List<Integer> unsortedList = new ArrayList<>();
        unsortedList.add(2);
        unsortedList.add(1);
        unsortedList.add(4);
        unsortedList.add(3);
        unsortedList.add(2);

        System.out.println("Third smallest element in list is: " + new KthSmallestElement().kthSmallest(unsortedList, 3));
    }

    /**
     * Construct min heap and execute poll() kth times to reach the kth smallest element
     *
     * Time complexity: O(N + K*logN), where O(N) for heap construction and O(K*logN) for k extractMin() operations
     *
     * Space complexity: O(N) for heap construction
     */
    public int kthSmallest(final List<Integer> A, int B) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Integer i : A) {
            minHeap.add(i);
        }

        int result = 0;
        for (int i = 0; i < B; i++) {
            result = minHeap.poll();
        }
        return result;
    }
}
