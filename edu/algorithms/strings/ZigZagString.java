package edu.algorithms.strings;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 *
 * P.......A........H.......N
 * ..A..P....L....S....I...I....G
 * ....Y.........I........R
 *
 * And then read line by line: PAHNAPLSIIGYIR
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
 * **Example 2 : **
 * ABCD, 2 can be written as
 *
 * A....C
 * ...B....D
 * and hence the answer would be ACBD.
 */
public class ZigZagString {

    public static void main(String[] args) {
        System.out.println(new ZigZagString().convert("PAYPALISHIRING", 3));
    }

    public String convert(String A, int B) {
        if (A == null || A.isEmpty() || B == 1) {
            return A;
        }

        String[] stringParts = new String[B];

        // initialize string parts
        stringParts[0] = String.valueOf(A.charAt(0));
        for (int i = 0; i < B; i++) {
            if (i == 0) {
                stringParts[i] = String.valueOf(A.charAt(0));
            } else {
                stringParts[i] = "";
            }
        }

        // up - 0; down - 1
        int direction = 1;
        int i = 1;

        while (i < A.length()) {
            if (direction == 1) {
                for (int j = 1; j < B; j++) {
                    if (i < A.length()) {
                        stringParts[j] = stringParts[j] + A.charAt(i++);
                    } else {
                        break;
                    }
                }
                direction = 0;
            } else {
                for (int j = B - 2; j >= 0; j--) {
                    if (i < A.length()) {
                        stringParts[j] = stringParts[j] + A.charAt(i++);
                    } else {
                        break;
                    }
                }
                direction = 1;
            }
        }

        StringBuilder result = new StringBuilder("");
        for (String s : stringParts) {
            result.append(s);
        }
        return result.toString();
    }
}
