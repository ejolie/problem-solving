package com.ejolie.challenge.july;

import java.util.LinkedList;
import java.util.List;

/**
 * Day11. Subsets
 */
public class Day11 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets2(nums);
        for (List<Integer> subset : result) {
            System.out.println(subset.toString());
        }
    }

    // 1. Backtracking
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        backtrack(res, new LinkedList<>(), nums, 0);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
        res.add(new LinkedList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(res, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    // 2. Bit masking
    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        int total = 1 << nums.length;
        for (int n = 0; n < total; n++) {
            List<Integer> subset = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                if (((1 << i) & n) != 0) {
                    subset.add(nums[i]);
                }
            }
            res.add(subset);
        }
        return res;
    }
}

