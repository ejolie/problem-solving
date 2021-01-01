package com.ejolie.challenge._2020.september;

/**
 * Day9. Compare Version Numbers
 */
public class Day9 {
    public static void main(String[] args) {
        System.out.println(compareVersion("0.1", "1.1"));
        System.out.println(compareVersion("1.0.1", "1"));
        System.out.println(compareVersion("7.5.2.4", "7.5.3"));
        System.out.println(compareVersion("1.01", "1.001"));
        System.out.println(compareVersion("1.0", "1.0.0"));
    }

    public static int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");

        int N = Math.max(nums1.length, nums2.length);
        for (int i = 0; i < N; i++) {
            int num1 = i < nums1.length ? Integer.parseInt(nums1[i]) : 0;
            int num2 = i < nums2.length ? Integer.parseInt(nums2[i]) : 0;
            if (num1 < num2) return -1;
            else if (num1 > num2) return 1;
        }
        return 0;
    }
}
