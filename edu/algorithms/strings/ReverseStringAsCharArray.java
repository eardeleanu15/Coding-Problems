package edu.algorithms.strings;

/**
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * You may assume all the characters consist of printable ascii characters.
 *
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 */
public class ReverseStringAsCharArray {

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        for (char c : s) {
            System.out.print(c + " ");
        }
    }

    public static void reverseString(char[] s) {
        if (s.length == 0 || s.length == 1) {
            return;
        }
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            swap(s, i, j);
            i++;
            j--;
        }
    }

    public static void swap(char[] s, int i, int j) {
        char k = s[i];
        s[i] = s[j];
        s[j] = k;
    }
}
