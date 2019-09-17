package edu.algorithms.array;

/**
 * Find a matching pair of a key in a sorted array.
 *
 * [1, 2, 3, 9]
 * sum = 8
 * result = false
 *
 *
 * [1, 2, 4, 4]
 * sum = 8
 * result = true
 */
public class MatchingPairSortedArray {

    public static void main(String[] args) {
        int[] vector = {1, 2 , 3 , 4};
        System.out.println("Vector (1, 2, 4, 4) has pair for sum 8: " + hasPair(vector, 8));

        int[] vector2 = {1, 2 , 3 , 9};
        System.out.println("Vector (1, 2, 3, 9) has pair for sum 8: " + hasPair(vector2, 8));
    }

    public static boolean hasPair(int[] vector, int sum) {
        int low = 0;
        int high = vector.length - 1;
        while (low < high) {
            int sumOfPair = vector[low] + vector[high];
            if (sumOfPair == sum) {
                return true;
            } else if (sumOfPair > sum) {
                high--;
            } else {
                low++;
            }
        }
        return false;
    }

}
