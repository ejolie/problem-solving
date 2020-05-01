package com.ejolie.challenge.april;

import java.util.Arrays;

/**
 * Day1. Single Number
 */
public class Day1 {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber2(nums));
    }

    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        for (; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                break;
            }
        }
        return nums[i];
    }

    // A XOR A = 0
    // A XOR 0 = A
    public static int singleNumber2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] = nums[0] ^ nums[i];
        }
        return nums[0];
    }
}