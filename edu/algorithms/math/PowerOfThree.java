package edu.algorithms.math;

/**
 * Given an integer, write a function to determine if it is a power of three.
 *
 * Example 1:
 * Input: 27
 * Output: true
 *
 * Example 2:
 * Input: 0
 * Output: false
 */
public class PowerOfThree {

    public static void main(String[] args) {
        System.out.println("Is 45 power of three: " + isPowerOfThree(45));
    }

    public static boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            } else {
                n = n / 3;
            }
        }
        return true;
    }
}
