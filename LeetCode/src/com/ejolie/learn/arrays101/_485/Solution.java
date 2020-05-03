package com.ejolie.learn.arrays101._485;

/**
 * 485. Max Consecutive Ones
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = nums[0] == 1 ? 1 : 0;
        int cnt = max;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                cnt++;
            } else {
                if (cnt > max) {
                    max = cnt;
                }
                cnt = 0;
            }
        }
        if (cnt > max) {
            max = cnt;
        }
        return max;
    }
}
