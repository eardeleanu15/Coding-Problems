package edu.algorithms.array;

import java.util.Arrays;
import java.util.List;

public class RotatedSortedArraySearch {

    public static void main(String[] args) {
        Integer[] vector = {101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100};
        System.out.println(new RotatedSortedArraySearch().search(Arrays.asList(vector), 202));
    }

    public int search(final List<Integer> a, int b) {
        int size = a.size();
        int pivot = a.get(0);
        int maxIndex = 0;
        for (int i = size - 1; i >= 1; i--) {
            if (a.get(i) > pivot) {
                maxIndex = i;
                break;
            }
        }
        if (maxIndex == 0) {
            if (pivot != b) {
                return -1;
            } else {
                return 0;
            }
        } else {
            if (b >= pivot) {
                int start = 0;
                int end = maxIndex;
                while (start <= end) {
                    int med = (start + end) / 2;
                    if (a.get(med) == b) {
                        return med;
                    } else if (a.get(med) < b) {
                        start = med + 1;
                    } else {
                        end = med - 1;
                    }
                }
            } else {
                int start = maxIndex + 1;
                int end = size - 1;
                while (start <= end) {
                    int med = (start + end) / 2;
                    if (a.get(med) == b) {
                        return med;
                    } else if (a.get(med) < b) {
                        start = med + 1;
                    } else {
                        end = med - 1;
                    }
                }
            }
            return -1;
        }
    }
}
