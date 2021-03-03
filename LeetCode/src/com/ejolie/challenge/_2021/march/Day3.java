package com.ejolie.challenge._2021.march;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Day3. Missing Number
 */
public class Day3 {
    public static void main(String[] args) {
        assertEquals(2, missingNumber(new int[]{3, 0, 1}));
        assertEquals(2, missingNumber(new int[]{0, 1}));
        assertEquals(8, missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
        assertEquals(1, missingNumber(new int[]{0}));
    }

    // 0 ms, 39.2 MB
    // - time: O(n)
    // - space: O(1)
    public static int missingNumber(int[] nums) {
        int N = nums.length;
        int expectedSum = (N * (N + 1)) / 2;
        int realSum = 0;
        for (int num : nums) {
            realSum += num;
        }
        return expectedSum - realSum;
    }

    // 2 ms, 39.6 MB
    public static int missingNumber_stream(int[] nums) {
        int N = nums.length;
        int expectedSum = (N * (N + 1)) / 2;
        int realSum = Arrays.stream(nums).sum();
        return expectedSum - realSum;
    }
}
