package com.ejolie.problems.easy._1732;

import static org.junit.Assert.assertEquals;

/**
 * 1732. Find the Highest Altitude
 */
public class Solution {
    public static void main(String[] args) {
        assertEquals(1, largestAltitude(new int[]{-5, 1, 5, 0, -7}));
        assertEquals(0, largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}));
    }

    public static int largestAltitude(int[] gain) {
        int maxAlt = 0;
        int currAlt = 0;
        for (int g : gain) {
            currAlt += g;
            maxAlt = Math.max(maxAlt, currAlt);
        }
        return maxAlt;
    }
}
