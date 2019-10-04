package edu.algorithms.strings;

/**
 * Given the array of strings A,
 * you need to find the longest string S which is the prefix of ALL the strings in the array.
 *
 * Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1
 * and S2.
 *
 * For Example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strings = {"aaaaaaaaaaaaaaaaaaaaaaaaaa",
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            "aa", "aaaaaaaaaaaaaaaaaaaaaa"};

        System.out.println("Longest common prefix is: " + new LongestCommonPrefix().longestCommonPrefix(strings));
    }

    public String longestCommonPrefix(String[] A) {
        if (A == null || A.length == 0) {
            return "";
        }

        // find shortest word in array
        String shortestWord = A[0];
        int shortestLength = shortestWord.length();
        for (int i = 1; i < A.length; i++) {
            if (shortestLength > A[i].length()) {
                shortestWord = A[i];
                shortestLength = A[i].length();
            }
        }

        String[] strings = new String[A.length - 1];
        int count = 0;
        for (String s : A) {
            if (!s.equals(shortestWord)) {
                strings[count++] = s;
            }
        }

        StringBuilder lcp = new StringBuilder("");
        for (int i = 0; i < shortestWord.length(); i++) {
            boolean lcpFound = false;
            for (String s : strings) {
                if (shortestWord.charAt(i) != s.charAt(i)) {
                    lcpFound = true;
                    break;
                }
            }
            if (lcpFound) {
                break;
            } else {
                lcp.append(shortestWord.charAt(i));
            }
        }
        return lcp.toString();
    }

}
