package edu.algorithms.strings;

/**
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 *
 *
 *
 * Constraints:
 *
 * haystack and needle consist only of lowercase English characters.
 */
public class FirstOccurrenceIndex {

    public static void main(String[] args) {
        System.out.println(strStr("one of the best programming languages is java", "est"));
    }

    public static int strStr(String haystack, String needle) {
        int index = -1;
        if (needle == null || needle.length() == 0) {
            return 0;
        } else if (haystack == null || haystack.length() == 0) {
            return index;
        } else if (needle.length() > haystack.length()) {
            return index;
        }

        boolean scanComplete = false;
        int indexScanStarted = -1;
        for (int i=0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                indexScanStarted = i;
                if (needle.length() > 1) {
                    int haystackPos = i;
                    boolean mismatch = false;
                    for (int j = 1; j < needle.length(); j++) {
                        haystackPos = haystackPos + 1;
                        if (haystackPos >= haystack.length() ||
                            haystack.charAt(haystackPos) != needle.charAt(j)) {
                            mismatch = true;
                            break;
                        }
                    }
                    if (!mismatch) {
                        scanComplete = true;
                    }
                } else {
                    scanComplete = true;
                }
            }
            if (scanComplete) {
                index = indexScanStarted;
                break;
            }
        }

        return index;
    }

}
