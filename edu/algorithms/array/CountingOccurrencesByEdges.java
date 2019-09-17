package edu.algorithms.array;

/**
 * Counting number of occurrences by finding left and right edges
 */
public class CountingOccurrencesByEdges {

    public static void main(String[] args) {
        int[] vector = {5, 5, 5, 5, 5};
        System.out.println("Number of occurrences of 5 in vector: " + countOccurrences(vector, 5));

    }

    public static int countOccurrences(int[] vector, int key) {
        int leftEdge = findLeftEdge(vector, key);
        int rightEdge = findRightEdge(vector, key);
        return rightEdge - leftEdge + 1;
    }

    public static int findLeftEdge(int[] vector, int key) {
        int start = 0;
        int end = vector.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (vector[mid] == key && ((mid == 0) || vector[mid - 1] != key)) {
                return mid;
            } else if (vector[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return 0;
    }

    public static int findRightEdge(int[] vector, int key) {
        int start  = 0;
        int end = vector.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (vector[mid] == key && ((mid == vector.length - 1) || vector[mid + 1] != key)) {
                return mid;
            } else if (vector[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return 0;
    }

}
