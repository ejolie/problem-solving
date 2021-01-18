package com.ejolie.challenge._2021.january;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Day18. Max Number of K-Sum Pairs
 */
public class Day18 {
    public static void main(String[] args) {
        assertEquals(2, maxOperations(new int[]{1, 2, 3, 4}, 5));
        assertEquals(1, maxOperations(new int[]{3, 1, 3, 4, 3}, 6));
    }

    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0, right = nums.length - 1;
        int ops = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) {
                left++;
            } else if (sum > k) {
                right--;
            } else {
                ops++;
                left++;
                right--;
            }
        }

        return ops;
    }
}
