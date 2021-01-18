package com.ejolie.challenge._2021.january;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Day18. Max Number of K-Sum Pairs
 * <p>
 * 1. Point
 * - find a pair (x, k - x)
 * - # of pairs
 * 1) if x * 2 == k, floor(count(x) / 2)
 * 2) else, min(count(x), count(k - x))
 */
public class Day18 {
    public static void main(String[] args) {
        assertEquals(2, maxOperations_twoPointer(new int[]{1, 2, 3, 4}, 5));
        assertEquals(1, maxOperations_twoPointer(new int[]{3, 1, 3, 4, 3}, 6));

        assertEquals(3, maxOperations_hashMap(new int[]{1, 1, 2, 3, 4, 4, 4, 4}, 5));
        assertEquals(1, maxOperations_hashMap(new int[]{3, 1, 3, 4, 3}, 6));
        assertEquals(0, maxOperations_hashMap(new int[]{3, 5, 1, 5}, 2));
    }

    // - time: O(n lg n)
    // - space: O(1)
    public static int maxOperations_twoPointer(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0, right = nums.length - 1;
        int ops = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) {
                left++;
            } else if (sum > k) {
                right--;
            } else {
                ops++;
                left++;
                right--;
            }
        }

        return ops;
    }

    // - time: O(n)
    // - space: O(n)
    public static int maxOperations_hashMap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, 1 + map.getOrDefault(num, 0));
        }

        int ops = 0;
        for (int num : map.keySet()) {
            if (num * 2 == k) {
                ops += map.get(num) / 2;
            } else if (map.containsKey(k - num)) {
                int min = Math.min(map.get(num), map.get(k - num));
                ops += min;

                map.put(num, map.get(num) - min);
                map.put(k - num, map.get(k - num) - min);
            }
        }

        return ops;
    }
}
