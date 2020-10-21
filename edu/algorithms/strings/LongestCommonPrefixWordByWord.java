package edu.algorithms.strings;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 */
public class LongestCommonPrefixWordByWord {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println("Longest Common Prefix is: " + longestCommonPrefix(strs));
    }

    /**
     * We can see that the longest common prefix holds the associative property
     *
     * LCP(string1, string2, string3)
     *          = LCP (LCP (string1, string2), string3)
     *
     * LCP (“flower”, “flow”, “flight”)
     *      =  LCP (LCP (“flower”, “flow”), “flight”)
     *      =  LCP (“flow”, “flight”) = “fl”
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        String lcp = LCP(strs[0], strs[1]);
        for (int i = 2; i < strs.length; i++) {
            lcp = LCP(lcp, strs[i]);
        }
        return lcp;
    }

    public static String LCP(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty()) {
            return "";
        }
        StringBuilder lcp = new StringBuilder("");
        int i = 0;
        int j = 0;
        while(i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                lcp.append(s1.charAt(i));
                i++;
                j++;
            } else {
                break;
            }
        }
        return lcp.toString();
    }
}
