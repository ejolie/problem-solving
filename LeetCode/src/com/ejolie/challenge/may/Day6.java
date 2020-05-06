package com.ejolie.challenge.may;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Day6. Majority Element
 */
public class Day6 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println(majorityElement(nums));
    }

    /**
     * 1. Sorting
     */
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 2. HashMap
     */
    public static int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            int newVal = map.getOrDefault(num, 0) + 1;
            map.put(num, newVal);

            if (newVal > nums.length / 2) {
                ans = num;
                break;
            }
        }
        return ans;
    }

    /**
     * 3. Moore Voting Algorithm
     */
    public static int majorityElement3(int[] nums) {
        int cnt = 0, ans = 0;
        for (int num : nums) {
            if (cnt == 0) {
                ans = num;
            }
            if (num != ans) {
                cnt--;
            } else {
                cnt++;
            }
        }
        return ans;
    }
}
