package com.example.sieveoferatosthenes;

import org.springframework.stereotype.Service;

import java.util.BitSet;


/*  Each boolean member in a boolean[] usually consumes one byte instead of just one bit so
    memory consumption for larger values

@Service
public class SieveOfEratosthenesService {
    public static List<Integer> getAllPrimes(final int maxInt) {

        boolean[] isPrime = new boolean[maxInt + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i <= maxInt; i++) {
            if (isPrime[i]) {
                // now mark the multiple of i as non-prime number
                for (int np = i * 2; np <= maxInt; np += i) {
                    isPrime[np] = false;
                }
            }
        }
        List<Integer> primeNumbers = new ArrayList<Integer>();

        for (int i = 2; i <= maxInt; i++) {
            if (isPrime[i]) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;

    }
}*/

/*
    Due to Bitset's use of int and doubling of int value in method
    limiting maxInt ui input to half max int size (1073741823)
 */
@Service
public class SieveOfEratosthenesService {
    public static String getAllPrimes(final int maxInt) {
        int size = maxInt + 1;
        BitSet primeNumberSet = new BitSet(size);
        primeNumberSet.flip(2, size);

        int i = 2;
        do {
            for (int j = i * 2; j < size; j += i)
                primeNumberSet.clear(j);
            i = primeNumberSet.nextSetBit(i+1);
        } while (i > 0);
        return primeNumberSet.toString();
    }

}



