package edu.algorithms.amz;

import java.util.Stack;

/**
 * Convert a non-negative integer num to its English words representation.
 *
 * Example 1:
 * Input: num = 123
 * Output: "One Hundred Twenty Three"
 *
 * Example 2:
 * Input: num = 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 *
 * Example 3:
 *
 * Input: num = 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 */
public class IntegerToEnglishWords {

    public static void main(String[] args) {
        System.out.println(numberToWords(1020));
    }

    public static String numberToWords(int num) {
        Stack<String> type = new Stack<>();
        type.push(" Billion");
        type.push(" Million");
        type.push(" Thousand");
        type.push("");

        Stack<String> wordStack = new Stack<>();
        char[] digits = Integer.toString(num).toCharArray();
        StringBuilder group = new StringBuilder();

        for (int i = digits.length - 1; i >= 0; i--) {
            group.insert(0, digits[i]);
            if (group.length() == 3) {
                int n = Integer.parseInt(group.toString());
                if (n == 0) {
                    type.pop();
                } else if (n < 10) {
                    wordStack.push(singleDigitWord(n) + type.pop());
                } else if (n < 20) {
                    wordStack.push(twoDigitWordLessThanTwenty(n) + type.pop());
                } else if (n < 100) {
                    wordStack.push(twoDigitWord(n) + type.pop());
                } else {
                    wordStack.push(threeDigitWord(n) + type.pop());
                }
                group = new StringBuilder();
            }
        }
        if (group.length() == 1) {
            int n = Integer.parseInt(group.toString());
            wordStack.push(singleDigitWord(n) + type.pop());
        } else if (group.length() == 2) {
            int n = Integer.parseInt(group.toString());
            if (n < 20) {
                wordStack.push(twoDigitWordLessThanTwenty(n) + type.pop());
            } else {
                wordStack.push(twoDigitWord(n) + type.pop());
            }
        }

        StringBuilder result = new StringBuilder();
        while (!wordStack.isEmpty()) {
            result.append(wordStack.pop() + " ");
        }

        return result.toString();
    }

    public static String singleDigitWord(int n) {
        String result = "";
        switch(n) {
        case 0:
            result = "Zero";
            break;
        case 1:
            result = "One";
            break;
        case 2:
            result = "Two";
            break;
        case 3:
            result = "Three";
            break;
        case 4:
            result = "Four";
            break;
        case 5:
            result = "Five";
            break;
        case 6:
            result = "Six";
            break;
        case 7:
            result = "Seven";
            break;
        case 8:
            result = "Eight";
            break;
        case 9:
            result = "Nine";
            break;
        }
        return result;
    }

    public static String twoDigitWordLessThanTwenty(int n) {
        String result = "";
        switch (n) {
        case 10:
            result = "Ten";
            break;
        case 11:
            result = "Eleven";
            break;
        case 12:
            result = "Twelve";
            break;
        case 13:
            result = "Thirteen";
            break;
        case 14:
            result = "Fourteen";
            break;
        case 15:
            result = "Fifteen";
            break;
        case 16:
            result = "Sixteen";
            break;
        case 17:
            result = "Seventeen";
            break;
        case 18:
            result = "Eighteen";
            break;
        case 19:
            result = "Nineteen";
            break;
        }
        return result;
    }

    public static String twoDigitPrefix(int n) {
        String result = "";
        switch(n) {
        case 2:
            result = "Twenty";
            break;
        case 3:
            result = "Thirty";
            break;
        case 4:
            result = "Forty";
            break;
        case 5:
            result = "Fifty";
            break;
        case 6:
            result = "Sixty";
            break;
        case 7:
            result = "Seventy";
            break;
        case 8:
            result = "Eighty";
            break;
        case 9:
            result = "Ninety";
            break;
        }
        return result;
    }

    public static String twoDigitWord(int n) {
        StringBuilder result = new StringBuilder("");
        result.append(twoDigitPrefix(n / 10));
        if (n % 10 != 0) {
            result.append (" ");
            result.append(singleDigitWord(n % 10));
        }

        return result.toString();
    }

    public static String threeDigitWord(int num) {
        StringBuilder result = new StringBuilder("");
        result.append(singleDigitWord(num / 100));
        result.append(" Hundred");
        int remaining = num % 100;
        if (remaining != 0) {
            if (remaining < 10) {
                result.append(" " + singleDigitWord(remaining));
            } else if (remaining < 20) {
                result.append(" " + twoDigitWordLessThanTwenty(remaining));
            } else {
                result.append(" " + twoDigitWord(remaining));
            }
        }
        return result.toString();
    }
}
