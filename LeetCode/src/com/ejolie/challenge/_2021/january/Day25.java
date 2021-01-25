package com.ejolie.challenge._2021.january;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Day25. Check If All 1's Are at Least Length K Places Away
 */
public class Day25 {
    public static void main(String[] args) {
        assertTrue(kLengthApart(new int[]{1, 0, 0, 0, 1, 0, 0, 1}, 2));
        assertTrue(kLengthApart(new int[]{1, 1, 1, 1, 1}, 0));
        assertTrue(kLengthApart(new int[]{0, 1, 0, 1}, 1));
        assertFalse(kLengthApart(new int[]{1, 0, 0, 1, 0, 1}, 2));
    }

    public static boolean kLengthApart(int[] nums, int k) {
        int prev = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (prev != -1 && i - prev - 1 < k) {
                    return false;
                }
                prev = i;
            }
        }

        return true;
    }
}
