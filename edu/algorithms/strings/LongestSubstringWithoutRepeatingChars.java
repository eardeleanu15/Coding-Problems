package edu.algorithms.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class LongestSubstringWithoutRepeatingChars {

    public static void main(String[] args) {
        System.out.println("Length of the longest substring in 'abcabcbb' is: " +
            lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        char[] chars = s.toCharArray();
        int lengthOfLongestSubstring = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            Set<Character> uniqueChars = new HashSet<>();
            uniqueChars.add(chars[i]);
            for (int j = i + 1; j < s.length(); j++) {
                if (uniqueChars.contains(chars[j])) {
                    break;
                } else {
                    uniqueChars.add(chars[j]);
                }
            }
            if (uniqueChars.size() > lengthOfLongestSubstring) {
                lengthOfLongestSubstring = uniqueChars.size();
            }
        }
        return lengthOfLongestSubstring;
    }
}
