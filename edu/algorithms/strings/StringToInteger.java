package edu.algorithms.strings;

/**
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
 * and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the
 * behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either
 * str is empty or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 *
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 */
public class StringToInteger {

    public static void main(String[] args) {
        System.out.println(atoi("4193 with words"));
        System.out.println(atoi("-91283472332"));
        System.out.println(atoi("-"));
    }

    public static int atoi(String str) {
        int result = 0;
        StringBuilder number = new StringBuilder();
        if (str == null || str.isEmpty()) {
            return result;
        }
        boolean conversionStarted = false;

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar == ' ') {
                if (conversionStarted) {
                    break;
                } else {
                    continue;
                }
            } else if (currentChar == '-' || currentChar == '+') {
                if (!conversionStarted) {
                    conversionStarted = true;
                } else {
                    break;
                }
                number.append(currentChar);
            } else if (Character.isDigit(currentChar)) {
                if (!conversionStarted) {
                    conversionStarted = true;
                }
                number.append(currentChar);
            } else {
                break;
            }
        }

        if (!conversionStarted) {
            return result;
        } else {
            try {
                result = Integer.parseInt(number.toString());
            } catch (NumberFormatException e) {
                if (number.length() > 1) {
                    if (number.charAt(0) == '-') {
                        result = Integer.MIN_VALUE;
                    } else {
                        result = Integer.MAX_VALUE;
                    }
                }

            }
        }
        return result;
    }
}
