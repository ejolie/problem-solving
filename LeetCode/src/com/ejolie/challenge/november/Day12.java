package com.ejolie.challenge.november;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Day12. Permutations II
 */
public class Day12 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = permuteUnique(nums);
        for (List<Integer> list : result) {
            System.out.println(list.toString());
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> temp = new LinkedList<>();
        permute(set, temp, nums, 0);
        return new LinkedList<>(set);
    }

    private static void permute(Set<List<Integer>> set, List<Integer> temp, int[] nums, int depth) {
        if (depth == nums.length) {
            set.add(new LinkedList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -99) {
                continue;
            }
            int num = nums[i];
            temp.add(num);
            nums[i] = -99;
            permute(set, temp, nums, depth + 1);
            nums[i] = num;
            temp.remove(temp.size() - 1);
        }
    }
}
