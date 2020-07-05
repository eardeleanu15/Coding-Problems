package edu.algorithms.strings;

/**
 * Write an algorithm which reverses the letters in words, like:
 * Input: I love Taxify
 * Output:I evol yfixaT
 *
 * Input is character array (not string) and output should also be character array.
 * Function needs to work in-place, modify the input array itself.
 * Don't use any extra arrays, string objects or language provider libraries. Use of temporary variables is allowed.
 */
public class ReverseSentenceAsCharArray {

    public static void main(String[] args) {
        char[] input = {'I', ' ', 'l','o','v','e',' ','T','a','x','i','f','y'};
        char[] reversed = reverseWords(input);

        for (char c : reversed) {
            System.out.print(c);
        }
        System.out.println();
    }

    public static char[] reverseWords(char[] input) {
        if (input.length > 1) {
            // start / end positions which marks the begining and ending of a word
            int start = 0;
            int end = 0;
            // begin mrking of a word
            boolean beginMark = false;
            for (int i = 0; i < input.length; i++) {
                if (input[i] != ' ') {
                    if (!beginMark) {
                        // re-initialize start, end positions
                        start = i;
                        end = i;
                        beginMark = true;
                    }
                    end++;
                } else {
                    reverseString(input, start, end - 1);
                    // re-initialize beginMark flag
                    beginMark = false;
                }
            }

            if (beginMark) {
                // last word has not been reversed
                reverseString(input, start, end - 1);
            }
        }

        return input;
    }

    public static void reverseString(char[] input, int start, int end) {
        if (end - start == 0 || end - start == 1) {
            return;
        }
        while (start < end) {
            swapChars(input, start, end);
            start++;
            end--;
        }
    }

    public static void swapChars(char[] s, int i, int j) {
        char k = s[i];
        s[i] = s[j];
        s[j] = k;
    }

}
