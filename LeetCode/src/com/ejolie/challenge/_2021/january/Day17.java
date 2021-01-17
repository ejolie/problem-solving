package com.ejolie.challenge._2021.january;

import static org.junit.Assert.assertEquals;

/**
 * Day17. Count Sorted Vowel Strings
 */
public class Day17 {

    public static void main(String[] args) {
        assertEquals(5, countVowelStrings_backtrack(1));
        assertEquals(15, countVowelStrings_backtrack((2));
        assertEquals(66045, countVowelStrings_backtrack((33));
    }

    public static int countVowelStrings_backtrack(int n) {
        return check(n, 0);
    }

    private static int check(int n, int start) {
        if (n == 0) {
            return 1;
        }

        int count = 0;
        for (int i = start; i < 5; i++) {
            count += check(n - 1, i);
        }

        return count;
    }
}
