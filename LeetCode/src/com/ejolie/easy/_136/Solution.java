package com.ejolie.easy._136;

import java.util.Arrays;

/*
 * 136. Single Number
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 4, 1, 2, 1, 2 };
        System.out.println(solution.singleNumber(nums));
    }

    // 1. Arrays.sort() and compare prev & next
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    // 2. XOR
    // a ^ 0 = a
    // a ^ a = 0
    public int singleNumber2(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    // 3. Arrays.stream()
    public int singleNumber3(int[] nums) {
        return Arrays.stream(nums).reduce((a, b) -> a ^ b).getAsInt();
    }
}
