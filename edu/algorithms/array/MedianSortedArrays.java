package edu.algorithms.array;

import java.util.ArrayList;
import java.util.List;

/**
 * There are two sorted arrays A and B of size m and n respectively.
 *
 * Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).
 *
 * Sample Input
 * A : [1 4 5]
 * B : [2 3]
 *
 * Sample Output: 3
 *
 * NOTE: IF the number of elements in the merged array is even, then the median is the average of n / 2 th and n/2 + 1th element.
 * For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5
 */
public class MedianSortedArrays {

    public static void main(String[] args) {
        List<Integer> first = new ArrayList<>();
        first.add(1);
        first.add(4);

        List<Integer> second = new ArrayList<>();
        second.add(2);
        second.add(3);

        System.out.println(new MedianSortedArrays().findMedianSortedArrays(first, second));
    }

    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        List<Integer> merged = new ArrayList<>(a.size() + b.size());

        int i = 0;
        int j = 0;
        while (i < a.size() && j < b.size()) {
            if (a.get(i) <= b.get(j)) {
                merged.add(a.get(i++));
            } else {
                merged.add(b.get(j++));
            }
        }

        while (i < a.size()) {
            merged.add(a.get(i++));
        }

        while (j < b.size()) {
            merged.add(b.get(j++));
        }

        int mergedSize = merged.size();
        double median;
        if (mergedSize % 2 == 0) {
            median = ((double) merged.get((mergedSize - 1)  / 2) + merged.get(((mergedSize - 1) / 2) + 1)) / 2;
        } else {
            median = merged.get((mergedSize - 1) / 2);
        }
        return median;
    }
}
