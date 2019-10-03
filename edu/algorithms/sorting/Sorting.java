package edu.algorithms.sorting;

public class Sorting {

    public static void main(String[] args) {
        int[] array = {9, 12, 3, 1, 5, 7, 90};

        Sorting sortingAlgorithms = new Sorting();
        sortingAlgorithms.quickSort(array);

        for (Integer i : array) {
            System.out.print(i + " ");
        }

        System.out.println("\nBinary search for element 7. Position: " +
            sortingAlgorithms.binarySearch(array, 0, array.length - 1, 7));
        System.out.println("Binary search for element 17. Position: " +
            sortingAlgorithms.binarySearch(array, 0, array.length - 1, 17));

        int[] array2 = {21, 102, 101 , 99, 5 ,1};
        sortingAlgorithms.mergeSort(array2);

        System.out.println();
        for (Integer i : array2) {
            System.out.print(i + " ");
        }

        int[] array3 = {21, 2, 11 , 9, 5 ,1};
        sortingAlgorithms.insertionSort(array3);

        System.out.println();
        for (Integer i : array3) {
            System.out.print(i + " ");
        }
    }

    public void quickSort(int[] array) {
        quickSortRecursive(array, 0, array.length - 1);
    }

    private void quickSortRecursive(int[] array, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(array, start, end);
            quickSortRecursive(array, start, partitionIndex - 1);
            quickSortRecursive(array, partitionIndex + 1, end);
        }
    }

    private int partition(int[] array, int start, int end) {
        // two indexes for iteration
        int i = start - 1;
        int pivot = array[end];

        for (int j = start; j < end; j++) {
            if (array[j] < pivot) {
                // swap
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        //swap pivot with elem at position i+1
        int temp = array[i + 1];
        array[i+1] = array[end];
        array[end] = temp;

        return i + 1;
    }

    public void mergeSort(int[] array) {
        mergeSortRecursive(array, 0, array.length - 1);
    }

    public void mergeSortRecursive(int[] array, int start, int end) {
        if (start < end) {
            int mid = start + (end-start) / 2;
            mergeSortRecursive(array, start, mid);
            mergeSortRecursive(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    private void merge(int[] array, int start, int mid, int end) {

        // create temp array
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = array[i++];
        }

        while (j <= end) {
            temp[k++] = array[j++];
        }

        //copy temp array
        for (i = start; i <= end; i++) {
            array[i] = temp[i - start];
        }
    }

    public void insertionSort(int[] array) {
        int start = 0 ;
        int end = array.length - 1;

        for (int i = start + 1; i <= end; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }

    }


    public int binarySearch(int[] array, int start, int end, int key) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end-start) / 2;
        if (key == array[mid]) {
            return mid;
        } else if (array[mid] > key) {
            return binarySearch(array, start, mid -1, key);
        } else {
            return binarySearch(array, mid +1, end, key);
        }
    }

}
