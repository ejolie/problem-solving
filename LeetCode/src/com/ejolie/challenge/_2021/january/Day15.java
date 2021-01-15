package com.ejolie.challenge._2021.january;

import static org.junit.Assert.assertEquals;

/**
 * Day15. Get Maximum in Generated Array
 */
public class Day15 {
    public static void main(String[] args) {
        assertEquals(3, getMaximumGenerated(7));
        assertEquals(1, getMaximumGenerated(2));
        assertEquals(2, getMaximumGenerated(3));
        assertEquals(0, getMaximumGenerated(0));
    }

    public static int getMaximumGenerated(int n) {
        if (n < 2) {
            return n;
        }

        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;

        int max = nums[1];
        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i / 2];
            if (i % 2 == 1) {
                nums[i] += nums[i / 2 + 1];
            }
            max = Math.max(max, nums[i]);
        }

        return max;
    }
}
