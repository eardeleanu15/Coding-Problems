package edu.algorithms.sorting;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = {7, 4, 5, 6, 10, 3, 2};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array, 0, array.length - 1);
        System.out.println("Sorted array");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    // Arr is an array of integer type
    // start and end are the starting and ending index of current interval of Arr

    void sort(int Arr[], int start, int end) {

        if(start < end) {
            int mid = (start + end) / 2;
            sort(Arr, start, mid);
            sort(Arr, mid+1, end);
            merge(Arr, start, mid, end);
        }
    }

    void merge(int Arr[], int start, int mid, int end) {

        // create a temp array
        int temp[] = new int[end - start + 1];

        // crawlers for both intervals and for temp
        int i = start, j = mid+1, k = 0;

        // traverse both arrays and in each iteration add smaller of both elements in temp
        while(i <= mid && j <= end) {
            if(Arr[i] <= Arr[j]) {
                temp[k] = Arr[i];
                i ++;
            }
            else {
                temp[k] = Arr[j];
                j ++;
            }
            k++;
        }

        // add elements left in the first interval
        while(i <= mid) {
            temp[k] = Arr[i];
            k ++; i ++;
        }

        // add elements left in the second interval
        while(j <= end) {
            temp[k] = Arr[j];
            k ++; j ++;
        }

        // copy temp to original interval
        for(i = start; i <= end; i += 1) {
            Arr[i] = temp[i - start];
        }
    }

}
