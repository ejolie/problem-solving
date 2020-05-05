package com.ejolie.challenge.may;

/**
 * Day4. Number Complement
 */
public class Day4 {
    public static void main(String[] args) {
        int num = 38;
        System.out.println(findComplement2(num));
    }

    /**
     * num = 100110
     * comp = 011001
     * sum = 111111
     * sum - num = comp
     */
    private static int findComplement(int num) {
        int sum = 0;
        while (sum < num) {
            sum = (sum << 1) | 1;
        }
        return sum - num;
    }

    private static int findComplement2(int num) {
        /**
         * `int mask = (Integer.highestOneBit(num) << 1) - 1;`
         * We don't need to left shift 1.
         * -> The highest 1 bit will always become 0 in the Complement result.
         */
        int mask = Integer.highestOneBit(num) - 1;
        num = ~num;
        return num & mask;
    }
}
