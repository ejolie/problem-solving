package com.ejolie.challenge._2021.january;

import static org.junit.Assert.assertEquals;

/**
 * Day10. Create Sorted Array through Instructions
 */
public class Day10 {
    static int[] c;

    public static void main(String[] args) {
        assertEquals(1, createSortedArray(new int[]{1, 5, 6, 2}));
        assertEquals(3, createSortedArray(new int[]{1, 2, 3, 6, 5, 4}));
        assertEquals(4, createSortedArray(new int[]{1, 3, 3, 3, 2, 4, 2, 1, 2}));
    }

    public static int createSortedArray(int[] instructions) {
        int res = 0;
        int n = instructions.length;
        int mod = (int) 1e9 + 7;
        c = new int[100001];

        for (int i = 0; i < n; ++i) {
            res = (res + Math.min(get(instructions[i] - 1), i - get(instructions[i]))) % mod;
            update(instructions[i]);
        }
        return res;
    }

    public static void update(int x) {
        while (x < 100001) {
            c[x]++;
            x += x & -x;
        }
    }

    public static int get(int x) {
        int res = 0;
        while (x > 0) {
            res += c[x];
            x -= x & -x;
        }
        return res;
    }
}
