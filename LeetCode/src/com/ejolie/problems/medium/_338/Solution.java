package com.ejolie.problems.medium._338;

import java.util.Arrays;

/*
 * 338. Counting Bits
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int num = 5;
        System.out.println(Arrays.toString(solution.countBits(num)));
    }

    // 1. dp[i] = dp[i - offset] + 1
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        int offset = 1;
        for (int i = 1; i <= num; ++i) {
            if (offset * 2 == i) {
                offset *= 2;
            }
            res[i] = res[i - offset] + 1;
        }
        return res;
    }

    // 2. Bit masking
    // 1) last digit : i & 1 (= i % 2)
    // 2) other digits : res[i >> 1] (= res[i / 2])
    public int[] countBits2(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}
