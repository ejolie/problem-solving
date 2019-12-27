package com.ejolie.easy._26;

/*
 * 26. Remove Duplicates from Sorted Array
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(solution.removeDuplicates(nums));
    }

    private int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[n] != nums[i]) {
                nums[++n] = nums[i];
            }
        }
        return n + 1;
    }
}
