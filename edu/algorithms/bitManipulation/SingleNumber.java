package edu.algorithms.bitManipulation;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example :
 *
 * Input : [1 2 2 3 1]
 * Output : 3
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] A = {10, 2, 2, 3, 3, 10, 22, 22, 25, 16, 25};
        System.out.println("MAP: Single number in array is: " + new SingleNumber().singleNumber(A));
        System.out.println("XOR SUM: Single number in array is: " + new SingleNumber().singleNumberXor(A));
    }

    // O(N) extra memory
    public int singleNumber(final int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                map.put(A[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    /**
     * A ^ A = 0
     * A ^ B ^ A = B
     */
    public int singleNumberXor(final int[] A) {
        int sum = 0;
        for (int a : A) {
            sum = sum ^ a;
        }
        return sum;
    }

}
