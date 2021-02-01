package com.ejolie.challenge._2021.february;

import static org.junit.Assert.assertEquals;

/**
 * Day1. Number of 1 Bits
 */
public class Day1 {

    public static void main(String[] args) {
        assertEquals(3, hammingWeight(11));
        assertEquals(31, hammingWeight(-3));
    }

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }

    public static int hammingWeight_builtInMethod(int n) {
        return Integer.bitCount(n);
    }
}
