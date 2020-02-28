package edu.algorithms.math;

public class GeneralizedGCD {

    public static void main(String[] args) {
        int[] arr = {6, 12, 24};
        System.out.println("Greatest Common Divisor is: "
            + new GeneralizedGCD().greatestCommonDivisor(arr.length, arr));
    }

    public int greatestCommonDivisor(int num, int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        } else if (num == 1) {
            return arr[0];
        }

        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(arr[i], result);

            if (result == 1) {
                return result;
            }
        }
        return result;
    }

    int gcd (int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

}
