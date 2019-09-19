package edu.algorithms.math;

public class PowerFunction {

    public static void main(String[] args) {
        System.out.println(new PowerFunction().calculatePow(5, 250));
    }

    public long calculatePow(long x, long y) {
        if (y == 0) {
            return 1;
        } else if (y % 2 == 0) {
            return calculatePow(x, y/2) * calculatePow(x, y/2);
        } else {
            return x * calculatePow(x, y/2) * calculatePow(x, y/2);
        }
    }

}
