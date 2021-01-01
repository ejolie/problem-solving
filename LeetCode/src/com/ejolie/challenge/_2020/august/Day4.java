package com.ejolie.challenge._2020.august;

/**
 * Day4. Power of Four
 */
public class Day4 {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(5));
    }

    /**
     * 4: 100
     * 3: 011
     * <p>
     * 16: 10000
     * 15: 01111
     * <p>
     * 64: 1000000
     * 63: 0111111
     */
    public static boolean isPowerOfFour(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0x55555555) != 0);
    }
}
