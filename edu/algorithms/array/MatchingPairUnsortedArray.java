package edu.algorithms.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Find a matching pair of a key in an unsorted array.
 *
 * [4, 2, 1, 4]
 * sum = 8
 * result = true
 *
 *
 * [-1, 8, 9, 3]
 * sum = 8
 * result = true
 */
public class MatchingPairUnsortedArray {

    public static void main(String[] args) {
        int[] vector = {4, 2 , 1 , 4};
        System.out.println("Vector (4, 2, 1, 4) has pair for sum 8: " + hasPair(vector, 8));

        int[] vector2 = {-1 , 8 , 9 , 3};
        System.out.println("Vector (-1, 8, 9, 3) has pair for sum 8: " + hasPair(vector2, 8));
    }

    public static boolean hasPair(int[] vector, int sum) {
        Set<Integer> complements = new HashSet<>();
        for (Integer i : vector) {
            if (complements.contains(i)) {
                return true;
            } else {
                complements.add(sum - i);
            }
        }
        return false;
    }

}
