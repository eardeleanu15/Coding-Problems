package edu.algorithms.strings;

import java.util.Stack;

/**
 * Given a string A.
 *
 * Return the string A after reversing the string word by word.
 *
 * NOTE:
 *
 * A sequence of non-space characters constitutes a word.
 *
 * Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
 *
 * If there are multiple spaces between words, reduce them to a single space in the reversed string.
 *
 * For Example
 *
 * Input 1:
 *     A = "the sky is blue"
 * Output 1:
 *     "blue is sky the"
 *
 * Input 2:
 *     A = "this is ib"
 * Output 2:
 *     "ib is this"
 */
public class ReverseString {

    public static void main(String[] args) {
        System.out.println(
            new ReverseString().reverse(" the  sky   is blue "));
    }

    public String reverse(String A) {
        if (A == null || A.isEmpty()) {
            return A;
        }

        StringBuilder word = new StringBuilder("");
        boolean begin = false;
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != ' ') {
                if (!begin) {
                    begin = true;
                }
                word.append(A.charAt(i));
            } else {
                if (begin) {
                    // mark end of word
                    stack.push(word.toString());
                    word = new StringBuilder("");
                    begin = false;
                }
            }
        }

        // add last word
        if (begin) {
            stack.push(word.toString());
        }

        StringBuilder reverse = new StringBuilder("");
        while (!stack.isEmpty()) {
            reverse.append(stack.pop());
            if (!stack.isEmpty()) {
                reverse.append(" ");
            }
        }
        return reverse.toString();
    }

}
