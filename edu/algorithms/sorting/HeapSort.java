package edu.algorithms.sorting;

public class HeapSort {

    public static void main(String[] args) {
        int[] array = {17, 3, 25, 1, 19, 36, 100};
        new HeapSort().sort(array);
    }

    public void sort(int[] array) {

        // build heap
        int n = array.length;
        for (int i = n / 2 - 1; i>=0; i--) {
            heapify(array, n, i);
        }

        // One by one extract first element from heap
        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            System.out.print(temp + " ");
            heapify(array, i, 0);
        }

    }

    /**
     * Heapify a subtree rooted with node i which is an index in arr[].
     *
     * @param array - heap as array
     * @param n - size of array
     * @param i - index in array
     */
    public void heapify(int[] array, int n, int i) {

        int largest = i;
        int leftChild = 2*i + 1;
        int rightChild = 2*i + 2;

        if (leftChild < n && array[largest] < array[leftChild]) {
            largest = leftChild;
        }

        if (rightChild < n && array[largest] < array[rightChild]) {
            largest = rightChild;
        }

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            heapify(array, n, largest);
        }
    }

}
