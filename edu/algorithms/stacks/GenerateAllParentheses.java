package edu.algorithms.stacks;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class GenerateAllParentheses {

    public int isValid(String A) {
        char openParenthese = '(';
        char closeParenthese = ')';
        char openCurly = '{';
        char closeCurly = '}';
        char openSquare = '[';
        char closeSquare = ']';

        boolean valid = true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == closeParenthese) {
                if (stack.isEmpty() || stack.pop() != openParenthese) {
                    valid = false;
                    break;
                }
            } else if (A.charAt(i) == closeCurly) {
                if (stack.isEmpty() || stack.pop() != openCurly) {
                    valid = false;
                    break;
                }
            } else if (A.charAt(i) == closeSquare) {
                if (stack.isEmpty() || stack.pop() != openSquare) {
                    valid = false;
                    break;
                }
            } else {
                stack.push(A.charAt(i));
            }
        }

        if (valid && (!stack.isEmpty())) {
            valid = false;
        }
        return valid ? 1 : 0;
    }
}
