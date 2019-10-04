package edu.algorithms.strings;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 *
 * Given s = "Hello World",
 *
 * return 5 as length("World") = 5.
 *
 * Please make sure you try to solve this problem without using library functions. Make sure you only traverse the string once.
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        String s = "  xDGBklKecz IAcOJYOH O  WY WPi";
        System.out.println("Length of last word in \" xDGBklKecz IAcOJYOH O  WY WPi\" is: "
            + new LengthOfLastWord().lengthOfLastWord(s));
    }

    public int lengthOfLastWord(final String A) {
        if (A == null || A.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (int i = A.length() - 1; i >= 0; i--) {
            if (A.charAt(i) == ' ' && count == 0) {
                continue;
            } else if (A.charAt(i) == ' ') {
                break;
            } else {
                count++;
            }
        }
        return count;
    }

}
