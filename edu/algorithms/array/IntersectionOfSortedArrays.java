package edu.algorithms.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IntersectionOfSortedArrays {

    public static void main(String[] args) {
        Integer[] A = {1, 3, 8, 10, 13, 13, 16, 16, 16, 18, 21, 23, 24, 31, 31, 31, 33, 35, 35, 37, 37, 38, 40, 41, 43, 47,
            47, 48, 48, 52, 52, 53, 53, 55, 56, 60, 60, 61, 61, 63, 63, 64, 66, 67, 67, 68, 69, 71, 80, 80, 80, 80, 80,
            80, 81, 85, 87, 87, 88, 89, 90, 94, 95, 97, 98, 98, 100, 101};

        Integer[] B = {5, 7, 14, 14, 25, 28, 28, 34, 35, 38, 38, 39, 46, 53, 65, 67, 69, 70, 78, 82, 94, 94, 98};

        IntersectionOfSortedArrays algorithm = new IntersectionOfSortedArrays();

        for (Integer i: algorithm.intersect(Arrays.asList(A), Arrays.asList(B))) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (Integer i : algorithm.intersectWithBinarySearch(Arrays.asList(A), Arrays.asList(B))) {
            System.out.print(i + " ");
        }
    }

    // O(m + n)
    public List<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        if (A == null || B == null || A.isEmpty() || B.isEmpty()) {
            return Collections.emptyList();
        }
        List<Integer> intersection = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < A.size() && j < B.size()) {
            if (A.get(i) < B.get(j)) {
                i++;
            } else if (A.get(i) > B.get(j)) {
                j++;
            } else {
                // equal elements; add to intersection list
                intersection.add(A.get(i));
                i++;
                j++;
            }
        }
        return intersection;
    }

    // Min ( O(M*logN), O(N*logM) )
    public List<Integer> intersectWithBinarySearch(List<Integer> A, List<Integer> B) {
        return A.size() > B.size() ? identifyIntersection(A, B) : identifyIntersection(B, A);
    }

    private List<Integer> identifyIntersection(List<Integer> upper, List<Integer> lower) {
        List<Integer> intersection = new ArrayList<>();

        for (Integer i : lower) {
            int key = Collections.binarySearch(upper, i);
            if ( key > 0 && !intersection.contains(i)) {
                intersection.add(i);
            }
        }
        return intersection;
    }

}
