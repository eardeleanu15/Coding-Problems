package edu.algorithms.strings;

/**
 * You are given a string S, and you have to find all the amazing substrings of S.
 *
 * Amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
 *
 * Input
 *
 * Only argument given is string S.
 * Output
 *
 * Return a single integer X mod 10003, here X is number of Amazing Substrings in given string.
 * Constraints
 *
 * 1 <= length(S) <= 1e6
 * S can have special characters
 * Example
 *
 * Input
 *     ABEC
 *
 * Output
 *     6
 *
 * Explanation
 * 	Amazing substrings of given string are :
 * 	1. A
 * 	2. AB
 * 	3. ABE
 * 	4. ABEC
 * 	5. E
 * 	6. EC
 * 	here number of substrings are 6 and 6 % 10003 = 6.
 */
public class AmazingSubstrings {

    public static void main(String[] args) {
        System.out.println("Number of amazing substrings from string 'ABEC' is: " +
            new AmazingSubstrings().solve("ABEC"));
    }

    public int solve(String A) {
        if (A == null || A.isEmpty()) {
            return 0;
        }
        int count = 0;
        String s = A.toLowerCase();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (isVowel(s.charAt(i))) {
                /**
                 * E is at pos 2 and we can construct N - 2 substrings, where N is the size of the string: E and EC
                 */
                count += n - i;
            }
        }

        return count % 10003;
    }

    public boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }

}
