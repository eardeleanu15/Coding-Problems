package edu.algorithms.backtracking;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.
 *
 * Example :
 * If n = 4 and k = 2, a solution is:
 *
 * [
 *   [1,2],
 *   [1,3],
 *   [1,4],
 *   [2,3],
 *   [2,4],
 *   [3,4],
 * ]
 */
public class Combinations {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> combinations = new Combinations().combine(4, 2);
    }

    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        if (B <= 0 || A < B) {
            return new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A == B) {
            ArrayList<Integer> combination = (ArrayList<Integer>) IntStream.rangeClosed(1, B).boxed().collect(Collectors.toList());
            result.add(combination);
        } else {
            ArrayList<Integer> item = new ArrayList<>();
            generateCombinations(A, B, 1, item, result);
        }

        return result;
    }

    private void generateCombinations(int n, int k, int start, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> result) {
        if (item.size() == k) {
            result.add(new ArrayList<>(item));
        } else {
            for (int i=start; i<=n; i++) {
                item.add(i);
                generateCombinations(n, k, i+1, item, result);
                item.remove(item.size() - 1);
            }
        }
    }

}
