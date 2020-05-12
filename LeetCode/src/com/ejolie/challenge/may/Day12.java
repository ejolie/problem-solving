package com.ejolie.challenge.may;

/**
 * Day12. Single Element in a Sorted Array
 */
public class Day12 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(singleNonDuplicate(nums));
    }

    public static int singleNonDuplicate(int[] nums) {
        int answer = nums[0];
        for (int i = 1; i < nums.length; i++) {
            answer ^= nums[i];
        }
        return answer;
    }
}
