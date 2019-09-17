package edu.algorithms.array;

import static edu.algorithms.utils.BinarySearch.binarySearchRecursive;

public class CountingOccurrences {

    public static void main(String[] args) {
        int[] vector = {1, 3, 4, 5, 5, 5, 5, 5, 7, 8, 9, 14};
        System.out.println("Number of occurrences of 5 in vector: " + countOccurrences(vector, 5));

    }

    public static int countOccurrences(int[] vector, int key) {
        int occurrencesCount = 0;
        int keyIndex = binarySearchRecursive(vector, 0, vector.length -1, key);
        if (keyIndex == -1) {
            return occurrencesCount;
        } else {
            occurrencesCount++;
            int leftIndex = keyIndex;
            while (leftIndex > 0) {
                if (vector[--leftIndex] == key) {
                    occurrencesCount++;
                } else {
                    break;
                }
            }
            int rightIndex = keyIndex;
            while(rightIndex < vector.length -1) {
                if (vector[++rightIndex] == key) {
                    occurrencesCount++;
                } else {
                    break;
                }
            }
        }
        return occurrencesCount;
    }

}
