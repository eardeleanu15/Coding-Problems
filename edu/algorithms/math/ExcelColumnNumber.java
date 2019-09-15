package edu.algorithms.math;

/**
 * Given a column title as appears in an Excel sheet, return its corresponding column number.
 *
 * Example:
 *
 *     A -> 1
 *
 *     B -> 2
 *
 *     ...
 *
 *     Z -> 26
 *
 *     AA -> 27
 *
 *     AB -> 28
 */
public class ExcelColumnNumber {

    public static void main(String[] args) {
        System.out.println(new ExcelColumnNumber().titleToNumber("Z"));
        System.out.println(new ExcelColumnNumber().titleToNumber("AB"));
        System.out.println(new ExcelColumnNumber().titleToNumber("AC"));
    }

    public static int titleToNumber(String A) {
        // AB = B * pow(26,0) + A * pow(26,1)
        int result = 0;
        char[] reverseString = new StringBuilder(A).reverse().toString().toCharArray();
        for (int i = 0; i < reverseString.length; i++) {
            result += (reverseString[i] - 'A' + 1) * (int) Math.pow(26, i);
        }
        return result;
    }

}
