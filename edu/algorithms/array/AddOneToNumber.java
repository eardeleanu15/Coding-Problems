package edu.algorithms.array;

import java.util.Arrays;

/**
 * Given a non-negative number represented as an array of digits,
 *
 * add 1 to the number ( increment the number represented by the digits ).
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * Examples:
 * If the vector has [1, 2, 3]
 * the returned vector should be [1, 2, 4]
 * as 123 + 1 = 124
 *
 * If the vector has [9, 9, 9]
 * the returned vector should be [1, 0, 0, 0]
 *
 * Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
 * A : For the purpose of this question, YES
 *
 * Q: Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
 * A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit
 */
public class AddOneToNumber {

    public static void main(String[] args) {
        int[] array = {8 , 5, 9};

        int[] plusOneArray = new AddOneToNumber().plusOne(array);
        for (int i : plusOneArray) {
            System.out.print(i + " ");
        }

    }

    public int[] plusOne(int[] A) {

        int zeroCount = 0;

        for (int i = 0; i< A.length; i++) {
            if (A[i] == 0 ) {
                zeroCount++;
            } else if (A[i] != 0) {
                break;
            }
        }

        // all elements are zero, return single element array
        if (zeroCount == A.length) {
            return new int[] {1};
        }

        // create new array without zero elements
        int[] sanitizedArray = new int[A.length - zeroCount];
        int counter = 0;
        for (int i = zeroCount; i < A.length; i++) {
            sanitizedArray[counter++] = A[i];
        }


        // iterate from end to start and add one
        for (int i = sanitizedArray.length -1; i>=0; i--) {
            if (sanitizedArray[i] + 1 != 10) {
                sanitizedArray[i]++;
                break;
            } else {
                if (i == 0) {
                    // if (first element + 1) equal 10 the allocate extra space
                    sanitizedArray = Arrays.copyOf(sanitizedArray, sanitizedArray.length + 1);
                    sanitizedArray[0] = 1;
                } else {
                    // if (current element + 1) equal 10 set it to 0 and continue
                    sanitizedArray[i] = 0;
                }
            }
        }

        return sanitizedArray;
    }

}
