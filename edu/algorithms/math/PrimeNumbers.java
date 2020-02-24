package edu.algorithms.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Generating a list of prime numbers up to a maximum value.
 *
 * Implementation of Sieve of Eratosthenes algorithm
 */
public class PrimeNumbers {

    public static void main(String[] args) {
        int max = 100;
        List<Integer> primes = new PrimeNumbers().findPrimeNumbers(max);
        System.out.println("Prime numbers up to " + max + ":");
        for (Integer i : primes) {
            System.out.print(i + " ");
        }
    }

    public List<Integer> findPrimeNumbers(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] primeFlags = new boolean[n];
        // set prime flags on true for all values
        Arrays.fill(primeFlags, true);

        int prime = 2;
        while (prime <= (int) Math.sqrt(n)) {
            identifyNonPrimes(primeFlags, prime);
            prime = getNextPrime(primeFlags, prime);
        }

        initializePrimeValues(primes, primeFlags);
        return primes;
    }

    private void initializePrimeValues(List<Integer> primes, boolean[] primeFlags) {
        for (int i = 0; i < primeFlags.length; i++) {
            if (primeFlags[i]) {
                primes.add(i);
            }
        }
    }

    private int getNextPrime(boolean[] primeFlags, int currentPrime) {
        int next = currentPrime + 1;
        while (next <= primeFlags.length && !primeFlags[next]) {
            // iterate until we reach end of array or we find a prime value, initialized with true
            next++;
        }
        return next;
    }

    private void identifyNonPrimes(boolean[] primeFlags, int prime) {
        /**
         * we can start with prime * prime because if we had a k * prime, where k < prime,
         * this values would already had been crossed
         */
        for (int i = prime * prime; i < primeFlags.length; i +=prime) {
            primeFlags[i] = false;
        }
    }

}
