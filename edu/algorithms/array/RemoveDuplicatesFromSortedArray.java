package edu.algorithms.array;

import java.util.Arrays;
import java.util.List;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        Integer[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};

        System.out.println("New size without duplicates: "
            + new RemoveDuplicatesFromSortedArray().removeDuplicates(Arrays.asList(arr)));
    }

    public int removeDuplicates(List<Integer> a) {
        if (a == null || a.isEmpty()) {
            return 0;
        }
        int writeIndex = 0;
        for (int i = 1; i < a.size(); i++) {
            if (!a.get(i).equals(a.get(writeIndex))) {
                a.set(++writeIndex, a.get(i));
            }
        }

        return writeIndex + 1;
    }
}
