package com.ejolie.challenge._2021.january;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Day14. Minimum Operations to Reduce X to Zero
 * - Point
 * left + right == x (minimize)
 * => sum of a subarray in the middle == totalSum - x (maximize)
 */
public class Day14 {
    public static void main(String[] args) {
        assertEquals(2, minOperations(new int[]{1, 1, 4, 2, 3}, 5));
        assertEquals(-1, minOperations(new int[]{5, 6, 7, 8, 9}, 4));
        assertEquals(5, minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10));
        assertEquals(1, minOperations(new int[]{500, 1, 4, 2, 3}, 500));
    }

    public static int minOperations(int[] nums, int x) {
        int targetSum = Arrays.stream(nums).sum() - x;
        int maxSize = -1;
        int sum = 0;
        int l = 0, r = 0;
        while (l <= r && r < nums.length) {
            while (r < nums.length && sum + nums[r] <= targetSum) {
                sum += nums[r++];
            }
            if (sum == targetSum) {
                maxSize = Math.max(maxSize, r - l);
            }

            if (sum == 0) {
                l++;
                r = l;
            } else {
                sum -= nums[l];
                l++;
            }
        }

        return maxSize == -1 ? maxSize : nums.length - maxSize;
    }

    public static int minOperations_hashMap(int[] nums, int x) {
        int targetSum = -x;
        for (int num : nums) {
            targetSum += num;
        }

        // since all elements are positive, we have to take all of them
        if (targetSum == 0) {
            return nums.length;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (map.containsKey(sum - targetSum)) {
                result = Math.max(result, i - map.get(sum - targetSum));
            }

            // no need to check containsKey since sum is unique
            map.put(sum, i);
        }

        return result == Integer.MIN_VALUE ? -1 : nums.length - result;
    }

    public static int minOperations_slidingWindow(int[] nums, int x) {
        int targetSum = Arrays.stream(nums).sum() - x;
        int size = -1;
        int n = nums.length;

        for (int lo = -1, hi = 0, sum = 0; hi < n; ++hi) {
            sum += nums[hi];
            while (lo + 1 < n && sum > targetSum) {
                sum -= nums[++lo];
            }

            if (sum == targetSum) {
                size = Math.max(size, hi - lo);
            }
        }

        return size < 0 ? -1 : n - size;
    }
}
