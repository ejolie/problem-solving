package com.ejolie.easy._7;

/*
 * 7. Reverse Integer
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int x = -123;
        System.out.println(solution.reverse(x));
    }

    // 1. StringBuilder.reverse()
    public int reverse(int x) {
        StringBuilder sb = x < 0 ? new StringBuilder(String.valueOf(-x)).append("-")
                : new StringBuilder(String.valueOf(x));
        String reversed = sb.reverse().toString();

        try {
            return Integer.parseInt(reversed);
        } catch (Exception e) {
            return 0;
        }
    }

    // 2. Math Pop & Push
    public int reverse2(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }

        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) res;
    }
}