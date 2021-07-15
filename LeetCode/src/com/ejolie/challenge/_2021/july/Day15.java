package com.ejolie.challenge._2021.july;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Day15. Valid Triangle Number
 */
public class Day15 {

    public static void main(String[] args) {
        assertEquals(3, triangleNumber(new int[]{2, 2, 3, 4}));
        assertEquals(4, triangleNumber(new int[]{4, 2, 3, 4}));
        assertEquals(0, triangleNumber(new int[]{0, 1, 0}));
        assertEquals(10, triangleNumber(new int[]{24, 3, 82, 22, 35, 84, 19}));
    }

    public static int triangleNumber(int[] nums) {
        int N = nums.length;
        if (N < 3) {
            return 0;
        }

        Arrays.sort(nums);

        int count = 0;
        for (int i = N - 1; i >= 2; i--) {
            if (nums[i] == 0) {
                continue;
            }
            for (int j = i - 1; j >= 1; j--) {
                if (nums[j] == 0) {
                    continue;
                }
                for (int k = j - 1; k >= 0; k--) {
                    if (nums[k] == 0) {
                        continue;
                    }
                    if (nums[j] + nums[k] > nums[i]) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
