package com.ejolie.challenge._2020.july;

/**
 * Day25. Find Minimum in Rotated Sorted Array II
 */
public class Day25 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 3}; // {3, 3, 1, 3};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return nums[left];
    }
}
