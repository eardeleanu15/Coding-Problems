package edu.algorithms.sorting;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 */
public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println("4th largest element in the array is: " +
            findKthLargest(nums, 4));
    }

    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (Integer i : nums) {
            maxHeap.offer(i);
        }
        while(!maxHeap.isEmpty() && k-- > 1) {
            maxHeap.poll();
        }
        return maxHeap.poll();
    }
}
