package edu.algorithms.math;

/**
 * Given 2 non negative integers m and n, find gcd(m, n)
 *
 * GCD of 2 integers m and n is defined as the greatest integer g such that g is a divisor of both m and n.
 *
 * Example
 *
 * m : 6
 * n : 9
 *
 * GCD(m, n) : 3
 */
public class GreatestCommonDivisor {

    public static void main(String[] args) {
        System.out.println(new GreatestCommonDivisor().gcd(9, 6));
    }

    public int gcd(int A, int B) {
        if(A == 0) return B;
        return gcd(B%A, A);
    }

}
