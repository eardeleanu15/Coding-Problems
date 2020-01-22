package edu.algorithms.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string,
 * find the length of the longest substring without repeating characters.
 *
 * Example:
 *
 * The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 *
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println("Longest substring for 'abcabcbb' is: " + new LongestSubstring().lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String A) {
        if (A == null || A.isEmpty()) {
            return 0;
        }

        String longestSubstring = "";
        char[] charArray = A.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            StringBuilder currentSubstring = new StringBuilder();
            currentSubstring.append(charArray[i]);

            Set<Character> presentChars = new HashSet<>();
            presentChars.add(charArray[i]);

            for (int j = i + 1; j < charArray.length; j++) {
                if (presentChars.contains(charArray[j])) {
                    break;
                } else {
                    presentChars.add(charArray[j]);
                    currentSubstring.append(charArray[j]);
                }
            }
            if (currentSubstring.length() > longestSubstring.length()) {
                longestSubstring = currentSubstring.toString();
            }
        }

        return longestSubstring.length();
    }

}
