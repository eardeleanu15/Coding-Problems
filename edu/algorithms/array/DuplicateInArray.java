package edu.algorithms.array;

import java.util.*;

/**
 * Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time
 * using less than O(n) space and traversing the stream sequentially O(1) times.
 *
 * Sample Input: [3 4 1 4 1]
 * Sample Output: 4
 *
 * If there are multiple possible answers ( like in the sample case above ), output any one.
 *
 * If there is no duplicate, output -1
 */
public class DuplicateInArray {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(4);
        numbers.add(1);
        numbers.add(4);
        numbers.add(1);
        System.out.println("Repeated Number: " + new DuplicateInArray().repeatedNumber(numbers));
    }

    public int repeatedNumber(final List<Integer> a) {
        Set<Integer> numbers = new HashSet<>();
        for (Integer i : a) {
            if (numbers.contains(i)) {
                return i;
            } else {
                numbers.add(i);
            }
        }
        return -1;
    }
}
