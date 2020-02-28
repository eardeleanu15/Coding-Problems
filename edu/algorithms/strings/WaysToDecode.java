package edu.algorithms.strings;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 *
 *
 *
 * Input Format:
 *
 * The first and the only argument is a string A.
 * Output Format:
 *
 * Return an integer, representing the number of ways to decode the string.
 * Constraints:
 *
 * 1 <= length(A) <= 1e5
 * Example :
 *
 * Input 1:
 *     A = "8"
 *
 * Output 1:
 *     1
 *
 * Explanation 1:
 *     Given encoded message "8", it could be decoded as only "H" (8).
 *
 *     The number of ways decoding "8" is 1.
 *
 * Input 2:
 *     A = "12"
 *
 * Output 2:
 *     2
 *
 * Explanation 2:
 *     Given encoded message "12", it could be decoded as "AB" (1, 2) or "L" (12).
 *
 *     The number of ways decoding "12" is 2.
 */
public class WaysToDecode {

    public static void main(String[] args) {
        System.out.println("Nr of ways to decode '1263' : " +
            new WaysToDecode().numDecodings("1263"));
    }

    public int numDecodings(String A) {
        if (A == null || A.isEmpty()) {
            return 0;
        }
        int n = A.length();
        int[] dp = new int[n+1];
        dp[0] = 1;

        if (A.charAt(0) != '0') {
            dp[1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            int first = Integer.parseInt(A.substring(i-1, i));
            int second = Integer.parseInt(A.substring(i-2, i));
            if (first >=1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
