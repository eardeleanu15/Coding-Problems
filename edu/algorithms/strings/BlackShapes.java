package edu.algorithms.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Given N x M character matrix A of O's and X's, where O = white, X = black.
 *
 * Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)
 *
 *
 *
 * Input Format:
 *
 *     The First and only argument is a N x M character matrix.
 * Output Format:
 *
 *     Return a single integer denoting number of black shapes.
 * Constraints:
 *
 *     1 <= N,M <= 1000
 *     A[i][j] = 'X' or 'O'
 * Example:
 *
 * Input 1:
 *     A = [ OOOXOOO
 *           OOXXOXO
 *           OXOOOXO  ]
 * Output 1:
 *     3
 * Explanation:
 *     3 shapes are  :
 *     (i)    X
 *          X X
 *     (ii)
 *           X
 *     (iii)
 *           X
 *           X
 * Note: we are looking for connected shapes here.
 *
 * XXX
 * XXX
 * XXX
 * is just one single connected black shape.
 */
public class BlackShapes {

    public static void main(String[] args) {
        List<String> matrix = new ArrayList<>();
        matrix.add("XXX");
        matrix.add("XXX");
        matrix.add("XXX");

        System.out.println("Number of shapes; " +
            new BlackShapes().black(matrix));
    }

    public int black(List<String> A) {
        int shapes = 0;
        if (A == null || A.isEmpty()) {
            return shapes;
        }

        int n = A.size();
        int m = A.get(0).length();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A.get(i).charAt(j) == 'X') {
                    colorNeighbors(A, i, j, n, m);
                    shapes++;
                }
            }
        }

        return shapes;
    }

    public void colorNeighbors(List<String> A, int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return;
        }

        if (A.get(i).charAt(j) != 'X') {
            return;
        }

        StringBuilder newLine = new StringBuilder(A.get(i));
        newLine.setCharAt(j, '0');
        A.set(i, newLine.toString());

        colorNeighbors(A, i + 1, j, n, m);
        colorNeighbors(A, i - 1, j, n, m);
        colorNeighbors(A, i, j + 1, n, m);
        colorNeighbors(A, i, j - 1, n, m);
    }
}
