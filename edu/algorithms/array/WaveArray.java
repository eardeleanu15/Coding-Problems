package edu.algorithms.array;

import java.util.Arrays;

/**
 * Given an array of integers, sort the array into a wave like array and return it,
 * In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....
 *
 * Example:
 * Given [1, 2, 3, 4]
 *
 * One possible answer : [2, 1, 4, 3]
 * Another possible answer : [4, 1, 3, 2]
 *
 * NOTE : If there are multiple answers possible, return the one that's lexicographically smallest.
 * So, in example case, you will return [2, 1, 4, 3]
 */
public class WaveArray {

    public static void main(String[] args) {
        int[] arr = {4, 3 , 2 ,1, 8 ,9 ,12};
        for (int i : new WaveArray().wave(arr)) {
            System.out.print(i + " ");
        }
    }

    public int[] wave(int[] A) {
        // array length
        int n = A.length;
        // sort array
        Arrays.sort(A);

        for (int i=0,j=1; i<=n-2; i = i+ 2,j = j + 2) {
            // swap pairs of A[i] and A[j]
            int first = A[i];
            A[i] = A[j];
            A[j] = first;
        }

        return A;
    }
}
