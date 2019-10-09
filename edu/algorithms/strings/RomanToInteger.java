package edu.algorithms.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string A representing a roman numeral.
 * Convert A into integer.
 *
 * A is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInteger {

    Map<Character, Integer> romanNumerals = new HashMap<>();

    public RomanToInteger() {
        romanNumerals.put('I', Integer.valueOf(1));
        romanNumerals.put('V', Integer.valueOf(5));
        romanNumerals.put('X', Integer.valueOf(10));
        romanNumerals.put('L', Integer.valueOf(50));
        romanNumerals.put('C', Integer.valueOf(100));
        romanNumerals.put('D', Integer.valueOf(500));
        romanNumerals.put('M', Integer.valueOf(1000));
    }

    public static void main(String[] args) {
        System.out.println("MDCCCIV = " + new RomanToInteger().romanToInt("MDCCCIV"));
    }


    public int romanToInt(String A) {

        if (A == null || A.isEmpty()) {
            return 0;
        }

        if (A.length() == 1) {
            return romanNumerals.get(A.charAt(0));
        }

        int numeralLength = A.length();
        int result = 0;

        for (int i = 0; i < numeralLength; i++) {
            char numeral = A.charAt(i);
            // end of numeral
            if (i == numeralLength - 1) {
                result += romanNumerals.get(numeral);
                break;
            }

            if (numeral == 'I') {
                char nextNumeral = A.charAt(i+1);
                if (nextNumeral == 'V' || nextNumeral == 'X') {
                    result += (romanNumerals.get(nextNumeral) - romanNumerals.get(numeral));
                    // increment counter
                    i++;
                } else {
                    result += romanNumerals.get(numeral);
                }
            } else if (numeral == 'X') {
                char nextNumeral = A.charAt(i+1);
                if (nextNumeral == 'L' || nextNumeral == 'C') {
                    result += (romanNumerals.get(nextNumeral) - romanNumerals.get(numeral));
                    // increment counter
                    i++;
                } else {
                    result += romanNumerals.get(numeral);
                }
            } else if (numeral == 'C') {
                char nextNumeral = A.charAt(i+1);
                if (nextNumeral == 'D' || nextNumeral == 'M') {
                    result += (romanNumerals.get(nextNumeral) - romanNumerals.get(numeral));
                    // increment counter
                    i++;
                } else {
                    result += romanNumerals.get(numeral);
                }
            } else {
                result += romanNumerals.get(numeral);
            }
        }
        return result;
    }
}
