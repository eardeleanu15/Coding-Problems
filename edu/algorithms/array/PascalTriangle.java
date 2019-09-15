package edu.algorithms.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Given numRows, generate the first numRows of Pascal’s triangle.
 *
 * Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.
 *
 * Example:
 * Given numRows = 3,
 *
 * Return:
 * [
 *   [1, 0, 0]
 *   [1, 1, 0]
 *   [1, 2, 1]
 * ]
 */
public class PascalTriangle {

    public static void main(String[] args) {
        int R = 5;
        int[][] result = new PascalTriangle().solve(R);

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < R; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] solve(int A) {
        int[][] arr = new int[A][A];

        // initiate first column
        for (int i = 0; i < A; i++) {
            arr[i][0] = 1;
        }

        // top, button
        int T = 1, B = A - 1;
        // left, right
        // int L = 0, R = A - 1;
        // initiate first row
        while (T <= B) {
            for (int i = 1; i < A; i++) {
                arr[T][i] = arr[T-1][i] + arr[T-1][i-1];
            }
            T++;
        }
        return arr;
    }


}
