package com.ejolie.medium._494;

import java.util.Arrays;

/*
 * 494. Target Sum
 */
public class Solution {
    int cnt;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        System.out.println(solution.findTargetSumWays(nums, S));
    }

    // 1. Brute Force + Recursion
    // - O(2^n) (n: nums.length)
    public int findTargetSumWays(int[] nums, int S) {
        calculate(nums, 0, 0, S);
        return cnt;
    }

    private void calculate(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S) cnt++;
        } else {
            calculate(nums, i + 1, sum + nums[i], S);
            calculate(nums, i + 1, sum - nums[i], S);
        }
    }

    // 2. Recursion + Memoization
    // - For every call to `calculate(nums, i, sum, S)`,
    //   we store the result obtained in `memo[i][sum + 1000]`.
    // - The factor of 1000 has been added as an offset to the `sum` value
    //   to map all the `sum`s possible to positive integer range.
    // - O(l * n) (l * n: memo array size, l: the range of sum, n: nums.length)
    public int findTargetSumWays2(int[] nums, int S) {
        int[][] memo = new int[nums.length][2001];
        for (int[] row: memo) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        return calculate(nums, 0, 0, S, memo);
    }

    private int calculate(int[] nums, int i, int sum, int S, int[][] memo) {
        if (i == nums.length) {
            if (sum == S) return 1;
            else return 0;
        } else {
            if (memo[i][sum + 1000] != Integer.MAX_VALUE) {
                return memo[i][sum + 1000];
            }
            int add = calculate(nums, i + 1, sum + nums[i], S, memo);
            int subtract = calculate(nums, i + 1, sum - nums[i], S, memo);
            memo[i][sum + 1000] = add + subtract;
            return memo[i][sum + 1000];
        }
    }

    // 3. 2D Dynamic Programming
    public int findTargetSumWays3(int[] nums, int S) {
        return 0;
    }

    // 4. 1D Dynamic Programming
    public int findTargetSumWays4(int[] nums, int S) {
        return 0;
    }
}
