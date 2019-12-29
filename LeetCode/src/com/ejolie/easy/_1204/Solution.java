package com.ejolie.easy._1204;

import java.util.Arrays;

/*
 * 1304. Find N Unique Integers Sum up to Zero
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
        System.out.println(Arrays.toString(solution.sumZero2(n)));
    }

    private int[] sumZero(int n) {
        int[] res = new int[n];
        if (n%2 == 1) {
            res[n/2] = 0;
        }
        for (int i = 0; i < n/2; i++) {
            res[i] = i+1;
            res[n-1-i] = -i-1;
        }
        return res;
    }

    private int[] sumZero2(int n) {
        int[] res = new int[n];
        for (int start = 0, end = n-1; start < end; ++start, --end) {
            res[start] = -end;
            res[end] = end;
        }
        return res;
    }
}
