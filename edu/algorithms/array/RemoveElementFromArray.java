package edu.algorithms.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Remove Element
 *
 * Given an array and a value, remove all the instances of that value in the array.
 * Also return the number of elements left in the array after the operation.
 * It does not matter what is left beyond the expected length.
 *
 *  Example:
 *
 * If array A is [4, 1, 1, 2, 1, 3]
 * and value elem is 1,
 * then new length is 3, and A is now [4, 2, 3]
 */
public class RemoveElementFromArray {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(3);
        System.out.println(new RemoveElementFromArray().removeElement(list, 1));
    }

    public int removeElement(List<Integer> a, int b) {
        int removals = 0;
        int elemIndex = -1;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) != b) {
                elemIndex++;
                a.set(elemIndex, a.get(i));
                removals++;
            }
        }
        a  = a.subList(0, removals);
        return a.size();
    }

    public int removeElementWithAPI(List<Integer> a, int b) {
        a.removeAll(Collections.singletonList(b));
        return a.size();
    }
}
