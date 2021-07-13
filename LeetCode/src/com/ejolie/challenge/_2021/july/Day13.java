package com.ejolie.challenge._2021.july;

/**
 * Day13. Find Peak Element
 */
public class Day13 {
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }
}
