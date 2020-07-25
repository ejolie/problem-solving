package com.ejolie.problems.medium._153;

/**
 * 153. Find Minimum in Rotated Sorted Array
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {6, 8, 1, 2, 4, 5};
        System.out.println(findMin(nums));
    }

    // 1. Brute Force
    public static int findMin(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                min = nums[i];
                break;
            }
        }
        return min;
    }

    // 2. Binary Search
    public static int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
