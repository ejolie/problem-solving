package com.ejolie.problems.easy._217;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 217. Contains Duplicate
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(containsDuplicate(nums));
    }

    /**
     * 1. Sorting
     * - Time: O(nlogn)
     * - Space: O(1)
     */
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    /**
     * 2. Hash Table
     * - Time: O(n)
     * - Space: O(n)
     */
    public static boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
    
}
