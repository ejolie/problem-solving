package com.ejolie.problems.medium._46;

import java.util.LinkedList;
import java.util.List;

/**
 * 46. Permutations
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permute(nums);
        for (List<Integer> perm : result) {
            System.out.println(perm.toString());
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, res, new LinkedList<>(), visited);
        return res;
    }

    private static void backtrack(int[] nums, List<List<Integer>> res, List<Integer> perm, boolean[] visited) {
        if (perm.size() == nums.length) {
            res.add(new LinkedList<>(perm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            perm.add(nums[i]);
            backtrack(nums, res, perm, visited);
            visited[i] = false;
            perm.remove(perm.size() - 1);
        }
    }
}
