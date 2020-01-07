package com.ejolie.easy._169;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 169. Majority Element
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(solution.majorityElement(nums));
    }

    // 0. HashMap
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        int majority = nums.length / 2 + 1;
        for (Integer key : map.keySet()) {
            if (map.get(key) >= majority) {
                return key;
            }
        }
        return -1;
    }

    // 1. Brute Force - O(n^2)
    public int majorityElement2(int[] nums) {
        int majorityCount = nums.length / 2;

        for (int num : nums) {
            int cnt = 0;
            for (int elem : nums) {
                if (elem == num) cnt++;
            }

            if (cnt > majorityCount) {
                return num;
            }
        }

        return -1;
    }

    // 2. HashMap - O(n)
    public int majorityElement3(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();
    }

    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }
        return counts;
    }

    // 3. Sorting - O(nlogn)
    public int majorityElement4(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // 5. Divide and Conquer
    public int majorityElement5(int[] nums) {
        return 0;
    }

    // 6. Boyer-Moore Voting Algorithm
    public int majorityElement6(int[] nums) {
        return 0;
    }
}
