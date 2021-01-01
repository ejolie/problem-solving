package com.ejolie.challenge._2020.july;

import java.util.*;

/**
 * Day8. 3Sum
 */
public class Day8 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(nums);
        for (List<Integer> triplet : res) {
            System.out.println(triplet.toString());
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return Collections.emptyList();

        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                if (sum < 0) l++;
                else if (sum > 0) r--;
                else {
                    res.add(new LinkedList<>(Arrays.asList(nums[i], nums[l], nums[r])));

                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                }
            }
        }

        return res;
    }
}
