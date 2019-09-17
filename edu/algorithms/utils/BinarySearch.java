package edu.algorithms.utils;

public class BinarySearch {

    public static int binarySearchRecursive(int[] vector, int low, int high, int key) {
        // vector end
        if (high < low) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (key == vector[mid]) {
            return mid;
        }else if (key > vector[mid]) {
            return binarySearchRecursive(vector, mid + 1, high, key);
        } else if (key < vector[mid]) {
            return binarySearchRecursive(vector, low, mid - 1, key);
        }

        return -1;
    }

    public static int binarySearchIterative(int[] vector, int key) {
        int low = 0;
        int high = vector.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (vector[mid] == key) {
                return mid;
            } else if (vector[mid] > key) {
                high = mid - 1;
            } else if (vector[mid] < key) {
                low = mid + 1;
            }
        }
        return -1;
    }

}
