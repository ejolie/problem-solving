package com.ejolie.challenge.may;

/**
 * Day1. First Bad Version
 */
public class Day1 extends VersionControl {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(2126753390));
    }

    public static int firstBadVersion(int n) {
        int lo = 1, hi = n;
        while (lo <=hi) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
