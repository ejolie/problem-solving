package com.ejolie.problems.easy._1365;

import static org.junit.Assert.assertEquals;

/**
 * 1365. How Many Numbers Are Smaller Than the Current Number
 */
public class Solution {
    public static void main(String[] args) {
        assertEquals(new int[]{4, 0, 1, 1, 3}, smallerNumbersThanCurrent_bruteForce(new int[]{8, 1, 2, 2, 3}));
    }

    public static int[] smallerNumbersThanCurrent_bruteForce(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (j != i && nums[j] < nums[i]) {
                    count++;
                }
            }
            result[i] = count;
        }

        return result;
    }

}
