package edu.algorithms.math;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed.
 * Negative numbers are not palindromic.
 *
 * Example :
 *
 * Input : 12121
 * Output : 1
 *
 * Input : 123
 * Output : 0
 */
public class PalindromeInteger {

    public static void main(String[] args) {
        System.out.println("Is 2147447412 Palindrome: " + isPalindrome(2147447412));
        System.out.println("Is 123 Palindrome: " + isPalindrome(123));
        System.out.println("Is 12121 Palindrome: " + isPalindrome(12121));
    }

    public static int isPalindrome(int A) {
        // negative number case
        if (A < 0) {
            return 0;
        } else if (A >=0 && A <= 9) {
            // single digit case
            return 1;
        } else {
            int reverseNum = 0;
            int initialNum = A;
            while (initialNum > 0) {
                reverseNum = reverseNum * 10 + initialNum % 10;
                initialNum = initialNum / 10;
            }
            if (A == reverseNum) {
                return 1;
            }
        }
        return 0;
    }

}
