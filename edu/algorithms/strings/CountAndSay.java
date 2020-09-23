package edu.algorithms.strings;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 *
 *
 * Example 1:
 *
 * Input: 1
 * Output: "1"
 * Explanation: This is the base case.
 * Example 2:
 *
 * Input: 4
 * Output: "1211"
 * Explanation: For n = 3 the term was "21" in which we have two groups "2" and "1", "2" can be read as "12" which means f
 */
public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {
        String sequence = "1";
        if (n != 1) {
            for (int i = 2; i <= n; i++) {
                int count = 1;
                char value = sequence.charAt(0);
                StringBuilder sb = new StringBuilder();
                if (sequence.length() > 1) {
                    for (int j = 1; j < sequence.length(); j++) {
                        if (sequence.charAt(j) == value) {
                            count++;
                        } else {
                            sb.append(count);
                            sb.append(value);
                            count = 1;
                            value = sequence.charAt(j);
                        }
                    }
                }
                sb.append(count);
                sb.append(value);
                sequence = sb.toString();
            }
        }
        return sequence;
    }
}
