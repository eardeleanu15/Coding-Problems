package edu.algorithms.math;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.

 * Input: 123
 * Output: 321

 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(-321));
    }

    public static int reverse(int x) {
        int result = 0;
        StringBuilder reversed = new StringBuilder();
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = Math.abs(x);
        }

        while (x > 0) {
            reversed.append(x % 10);
            x = x / 10;
        }
        try {
            if (negative) {
                result = -Integer.parseInt(reversed.toString());
            } else {
                result = Integer.parseInt(reversed.toString());
            }
        } catch (NumberFormatException e) {
            System.out.println("Reversed value overflows. Return 0");
        }
        return result;
    }
}
