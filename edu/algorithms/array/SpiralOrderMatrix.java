package edu.algorithms.array;

public class SpiralOrderMatrix {

    public static void main (String[] args) {

        /**
         * Given a matrix of m * n elements (m rows, n columns), return all elements of the matrix in spiral order.
         *
         * Given the following matrix:
         * [
         *     [ 1, 2, 3 ],
         *     [ 4, 5, 6 ],
         *     [ 7, 8, 9 ]
         * ]
         *
         * You should return: [1, 2, 3, 6, 9, 8, 7, 4, 5]
         */

        int[][] a = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[] result = spiralOrder(a);

        for (int i =0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }


    public static int[] spiralOrder(final int[][] A) {
        // number of rows
        int r = A.length;
        // number of columns
        int c = A[0].length;

        // result
        int[] result = new int[r*c];
        int incrementer = 0;

        // top, bottom index pointers
        int T = 0, B = r - 1;
        // left, right index pointers
        int L = 0, R = c - 1;

        /** direction of matrix traversal
         * 0 right
         * 1 down
         * 2 left
         * 3 up
         */
        int dir = 0;

        while (T <= B && L <= R) {
            if (dir == 0) {
                for (int i = L; i<= R; i++) {
                    result[incrementer++] = A[T][i];
                }
                T++;
            } else if (dir == 1) {
                for (int i = T; i <= B; i++) {
                    result[incrementer++] = A[i][R];
                }
                R--;
            } else if (dir == 2) {
                for (int i = R; i >= L; i--) {
                    result[incrementer++] = A[B][i];
                }
                B--;
            } else if (dir == 3) {
                for (int i = B; i >= T; i--) {
                    result[incrementer++] = A[i][L];
                }
                L++;
            }
            dir = (dir + 1) % 4;
        }

        return result;
    }

}
