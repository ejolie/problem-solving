package com.ejolie.challenge.september;

import java.util.TreeSet;

/**
 * Day2. Contains Duplicate III
 * - Math.abs(i - j) <= k => Sliding window of size k => BST of size k
 * - Math.abs(nums[i] - nums[j]) <= t
 */
public class Day2 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k = 3;
        int t = 0;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
    }

    /**
     * 1. TreeSet
     * - Time: O(nlog(min(n, k)))
     * - Space: O(min(n, k))
     */
    private static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long floor = set.floor((long) nums[i]);
            if (floor != null && nums[i] - floor <= t) {
                return true;
            }

            Long ceiling = set.ceiling((long) nums[i]);
            if (ceiling != null && ceiling - nums[i] <= t) {
                return true;
            }

            set.add((long) nums[i]);
            if (set.size() > k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

}
