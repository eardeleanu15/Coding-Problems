package edu.algorithms.strings;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode"
 * return 2.
 */
public class FirstUniqueCharInAString {

    public static void main(String[] args) {
        System.out.println("First unique char index in 'loveleetcode': " + firstUniqChar("loveleetcode"));
    }

    public static int firstUniqChar(String s) {
        int index = -1;
        if (s == null || s.length() == 0) {
            return index;
        } else if (s.length() == 1) {
            return 0;
        }
        Map<Character, Integer> chars = new LinkedHashMap<>();
        for (int i =0; i < s.length(); i++) {
            Character currentChar = s.charAt(i);
            if (chars.containsKey(currentChar)) {
                chars.replace(currentChar, -1);
            } else {
                chars.put(currentChar, i);
            }
        }
        for (Integer entryValue : chars.values()) {
            if (entryValue != -1) {
                index = entryValue;
                break;
            }
        }
        return index;
    }
}
