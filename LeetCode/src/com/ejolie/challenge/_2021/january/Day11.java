package com.ejolie.challenge._2021.january;

import static org.junit.Assert.assertArrayEquals;

/**
 * Day11. Merge Sorted Array
 */
public class Day11 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, 3, nums2, 3);
        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);

        int[] arr1 = new int[]{1};
        int[] arr2 = new int[]{};
        merge(arr1, 1, arr2, 0);
        assertArrayEquals(new int[]{1}, arr1);
    }

    public static void merge_insertion(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        for (int j = 0; j < n; j++) {
            int key = nums2[j];
            while (i >= 0 && nums1[i] > key) {
                nums1[i + 1] = nums1[i];
                i--;
            }
            nums1[i + 1] = key;
            i = m + j;
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
