package com.ejolie.problems.easy._1317;

import java.util.Arrays;

/*
 * 1317. Convert Integer to the Sum of Two No-Zero Integers
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 11;
        System.out.println(Arrays.toString(solution.getNoZeroIntegers(n)));
    }

    private int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            if (checkNoZero(i) && checkNoZero(n - i)) {
                return new int[]{i, n - i};
            }
        }
        return null;
    }

    private boolean checkNoZero(int n) {
        while (n != 0) {
            if (n % 10 == 0) {
                return false;
            }
            n /= 10;
        }
        return true;
    }
}
