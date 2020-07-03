package edu.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        List<String> parenthesis = generateParenthesis(3);
        for (String s : parenthesis) {
            System.out.println(s);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateRecursive(ans, "", 0, 0, n);
        return ans;
    }

    public static void generateRecursive(List<String> parenthesis, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            parenthesis.add(current);
            return;
        }
        if (open < max) {
            generateRecursive(parenthesis, current + "(", open + 1, close, max);
        }
        if (close < open) {
            generateRecursive(parenthesis, current + ")", open, close + 1, max);
        }
    }
}
