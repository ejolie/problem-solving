package com.ejolie.challenge.july;

/**
 * Day1. Arranging Coins
 */
public class Day1 {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(arrangeCoins(n));
    }

    // 1. Brute Force
    public static int arrangeCoins(int n) {
        int k = 0;
        while (n > 0) {
            k++;
            n -= k;
        }
        return n == 0 ? k : k - 1;
    }

    // 2, Binary Search
    public static int arrangeCoins2(int n) {
        long lo = 0, hi = n;
        long mid, curr;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            curr = mid * (mid + 1) / 2;
            if (curr == n) return (int) mid;
            if (n < curr) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return (int) hi;
    }

    // 3. Math
    public static int arrangeCoins3(int n) {
        return (int) (Math.sqrt(8L * n + 1) - 1) / 2;
    }
}
