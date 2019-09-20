package edu.algorithms.stacks;

import java.util.Stack;

/**
 * Given a string A representing an absolute path for a file (Unix-style).
 *
 * Return the string A after simplifying the absolute path.
 *
 * Note:
 *
 * Absolute path always begin with ’/’ ( root directory ).
 *
 * Path will not have whitespace characters.
 *
 * For Example
 *
 * Input 1:
 *     A = "/home/"
 * Output 1:
 *     "/home"
 *
 * Input 2:
 *     A = "/a/./b/../../c/"
 * Output 2:
 *     "/c"
 */
public class SimplifyDirectoryPath {

    public static void main(String[] args) {
        System.out.println(new SimplifyDirectoryPath().simplifyPath("/a/./b/../../c/"));
    }

    public String simplifyPath(String A) {
        Stack<String> stack = new Stack<>();
        String[] pathParts = A.split("/");
        for (String part : pathParts) {
            if (!part.isEmpty()) {
                if (part.equals(".")) {
                    continue;
                } else if (part.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(part);
                }
            }
        }
        if (stack.isEmpty()) {
            return "/";
        } else {
            StringBuilder simplifiedPath = new StringBuilder("");
            while(!stack.isEmpty()) {
                simplifiedPath.insert(0, stack.pop());
                simplifiedPath.insert(0, "/");
            }
            return simplifiedPath.toString();
        }
    }
}
