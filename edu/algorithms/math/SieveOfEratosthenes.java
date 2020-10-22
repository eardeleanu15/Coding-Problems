package edu.algorithms.math;

public class SieveOfEratosthenes {

    public static void main(String[] args) {
        System.out.println("Count primes up to 10: " + countPrimes(10) );
    }

    public static int countPrimes(int n) {
        // mark all as primes
        boolean[] primes = new boolean[n];
        for (int i = 2; i < n; i++) {
            primes[i] = true;
        }

        for (int i = 2; i * i < n; i++) {
            if (primes[i]) {
                for (int j = i * i; j < n; j+=i) {
                    primes[j] = false;
                }
            }
        }
        int countPrimes = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                countPrimes++;
            }
        }
        return countPrimes;
    }
}
