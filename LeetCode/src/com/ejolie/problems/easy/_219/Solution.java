package com.ejolie.problems.easy._219;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 219. Contains Duplicate II
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    /**
     * 1. HashMap
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = map.getOrDefault(nums[i], -1);
            if (idx > -1 && i - idx <= k) return true;
            map.put(nums[i], i);
        }
        return false;
    }

    /**
     * 2. Sliding Window
     */
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (!set.add(nums[i])) return true;
        }
        return false;
    }
}
