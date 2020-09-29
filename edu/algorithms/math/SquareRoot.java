package edu.algorithms.math;

/**
 * Find the square root of an integer.
 */
public class SquareRoot {

    public static void main(String[] args) {
        System.out.println("Square root of 26 is: " + squareRoot(26));
        System.out.println("Square root of 11 is: " + squareRoot(11));
    }

    public static int squareRoot(int num) {
        if (num == 0 || num == 1) {
            return num;
        }
        int start = 1;
        int end = num;
        int ans = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int square = mid * mid;
            if (square == num) {
                return mid;
            } else if (square < num) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

}
