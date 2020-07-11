package com.ejolie.challenge.july;

import java.util.LinkedList;
import java.util.List;

/**
 * Day11. Subsets
 */
public class Day11 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets(nums);
        for (List<Integer> subset : result) {
            System.out.println(subset.toString());
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        return res;
    }
}
