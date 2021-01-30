package com.ejolie.problems.medium._287;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * 287. Find the Duplicate Number
 */
public class Solution {
    public static void main(String[] args) {
        assertEquals(2, findDuplicate_noArray(new int[]{1, 3, 4, 2, 2}));
        assertEquals(3, findDuplicate_noArray(new int[]{3, 1, 3, 4, 2}));
        assertEquals(1, findDuplicate_noArray(new int[]{1, 1, 1, 1, 1}));
        assertEquals(1, findDuplicate_noArray(new int[]{1, 1, 2}));
        assertEquals(2, findDuplicate_noArray(new int[]{2, 2, 2, 2, 2}));
        assertEquals(7, findDuplicate_binarySearch(new int[]{7, 9, 7, 4, 2, 8, 7, 7, 1, 5}));
    }

    // - time: O(n)
    // - space: O(n)
    public static int findDuplicate_array(int[] nums) {
        int[] count = new int[nums.length + 1];
        for (int n : nums) {
            if (count[n] != 0) {
                return n;
            }
            count[n] += 1;
        }
        return -1;
    }

    // - time: O(n lg n)
    // - space: O(1)
    public static int findDuplicate_noArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    // - time: O(n lg n)
    // - space: O(1)
    // cf. Pigeonhole Principle
    public static int findDuplicate_binarySearch(int[] nums) {
        int lo = 1;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            for (int n : nums) {
                if (n <= mid) {
                    count++;
                }
            }
            if (count <= mid) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}
