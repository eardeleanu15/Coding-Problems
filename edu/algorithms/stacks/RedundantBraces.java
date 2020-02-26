package edu.algorithms.stacks;

import java.util.Stack;

/**
 * Given a string A denoting an expression. It contains the following operators ’+’, ‘-‘, ‘*’, ‘/’.
 *
 * Check whether A has redundant braces or not.
 *
 * Return 1 if A has redundant braces, else return 0.
 *
 * Note: A will be always a valid expression.
 *
 * Input 1:
 *     A = "((a + b))"
 * Output 1:
 *     1
 *     Explanation 1:
 *         ((a + b)) has redundant braces so answer will be 1.
 *
 * Input 2:
 *     A = "(a + (a + b))"
 * Output 2:
 *     0
 *     Explanation 2:
 *         (a + (a + b)) doesn't have have any redundant braces so answer will be 0.
 */
public class RedundantBraces {

    public static void main(String[] args) {
        System.out.println("Redundant Braces for expression ((a + b)) : " +
            (new RedundantBraces().braces("((a + b))") == 1 ? "yes" : "no"));
    }

    public int braces(String A) {
        int redundantBraces = 0;
        char openBrace = '(';
        char closedBrace = ')';

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < A.length(); i++) {
            // We keep pushing elements onto the stack till we encounter ')'
            if (A.charAt(i) != closedBrace) {
                stack.push(A.charAt(i));
            } else {
                // When we do encounter ')', we start popping elements till we find a matching '('
                StringBuilder sb = new StringBuilder("");
                while (stack.peek() != openBrace) {
                    sb.append(stack.pop());
                }
                // pop openBrace as well
                sb.append(stack.pop());
                /**
                 * If elements popped do not correspond to:
                 *  ** '(' -> length = 1
                 *  ** '(a' -> for expressions like a*(a)
                 */
                if ((sb.length() == 1 && sb.charAt(0) == openBrace) ||
                    sb.length() == 2) {
                    redundantBraces = 1;
                    break;
                }
            }
        }

        return redundantBraces;
    }
}
