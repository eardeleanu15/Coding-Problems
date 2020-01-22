package edu.algorithms.backtracking;

import java.util.ArrayList;

/**
 * Given a collection of numbers, return all possible permutations.
 *
 * Example:
 *
 * [1,2,3] will have the following permutations:
 *
 * [1,2,3]
 * [1,3,2]
 * [2,1,3]
 * [2,3,1]
 * [3,1,2]
 * [3,2,1]
 */
public class Permutations {

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);

        ArrayList<ArrayList<Integer>> permutations = new Permutations().permute(nums);
    }

    /**
     * Heap’s algorithm is used to generate all permutations of n objects.
     * The idea is to generate each permutation from the previous permutation by choosing a pair of elements to
     * interchange, without disturbing the other n-2 elements.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> permutations = new ArrayList<>();
        generatePermutations(A, permutations, A.size(), A.size());
        return permutations;
    }

    /**
     * 1. The algorithm generates (n-1)! permutations of the first n-1 elements, adjoining the last element to each of these.
     * This will generate all of the permutations that end with the last element.
     *
     * 2. If n is odd, swap the first and last element and if n is even, then swap the ith element (i is the counter starting from 0)
     * and the last element and repeat the above algorithm till i is less than n.
     *
     * 3. In each iteration, the algorithm will produce all the permutations that end with the current last element.
     */
    public void generatePermutations(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> permutations, int size, int n) {
        if (size == 1) {
            // add obtained permutation
            permutations.add(new ArrayList<>(nums));
            return;
        }

        for (int i=0; i < size; i++) {
            generatePermutations(nums, permutations, size - 1, n);

            // if size is odd, swap first and last
            // element
            if (size % 2 == 1)
            {
                int temp = nums.get(0);
                nums.set(0, nums.get(size-1));
                nums.set(size-1, temp);
            }
            // If size is even, swap ith and last
            // element
            else
            {
                int temp = nums.get(i);
                nums.set(i, nums.get(size-1));
                nums.set(size-1, temp);
            }
        }
    }

    public void swap(ArrayList<Integer> A, int l, int r){
        int temp = A.get(l);
        A.set(l,A.get(r));
        A.set(r,temp);
    }
}
