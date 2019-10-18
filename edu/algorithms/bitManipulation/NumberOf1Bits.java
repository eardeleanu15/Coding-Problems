package edu.algorithms.bitManipulation;

/**
 * Write a function that takes an unsigned integer and returns the number of 1 bits it has.
 *
 * Example:
 *
 * The 32-bit integer 11 has binary representation
 *
 * 00000000000000000000000000001011
 * so the function should return 3.
 *
 * Note that since Java does not have unsigned int, use long for Java
 */
public class NumberOf1Bits {

    public static void main(String[] args) {
        System.out.println("O(n): Nr of 1 bits in 11 is: " + new NumberOf1Bits().numSetBits(11));
        System.out.println("O(number_of_ones): Nr of 1 bits in 11 is: " + new NumberOf1Bits().numSetBits2(11));
    }

    // O(n) - convert into base 2 and count number of ones
    public int numSetBits(long a) {
        if (a == 0) {
            return 0;
        }
        String binaryValue = Long.toBinaryString(a);
        int count = 0;
        for (int i = 0; i < binaryValue.length(); i++) {
            if (binaryValue.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    // O(number_of_ones)
    public int numSetBits2(long l) {
        int count = 0 ;
        while (l > 0) {
            if ((l & 1) == 1) {
                count++;
            }
            l = l >> 1;
        }
        return count;
    }

}
