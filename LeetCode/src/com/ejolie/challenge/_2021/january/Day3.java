package com.ejolie.challenge._2021.january;

import static org.junit.Assert.assertEquals;

/**
 * Day3. Beautiful Arrangement
 */
public class Day3 {
    public static void main(String[] args) {
        assertEquals(1, countArrangement_visited(1));
        assertEquals(2, countArrangement_visited(2));
        assertEquals(3, countArrangement_visited(3));
    }

    public static int countArrangement_visited(int n) {
        boolean[] visited = new boolean[n + 1];
        return permute(n, 1, visited);
    }

    private static int permute(int n, int i, boolean[] visited) {
        if (i == n + 1) {
            return 1;
        }

        int count = 0;
        for (int num = 1; num <= n; num++) {
            if (!visited[num] && isBeautiful(num, i)) {
                visited[num] = true;
                count += permute(n, i + 1, visited);
                visited[num] = false;
            }
        }

        return count;
    }

    public static int countArrangement_swap(int n) {
        if (n == 0) {
            return 0;
        }

        int[] nums = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            nums[i] = i;
        }
        return permute(nums, n);
    }

    private static int permute(int[] nums, int start) {
        if (start == 0) {
            return 1;
        }

        int count = 0;
        for (int i = start; i > 0; i--) {
            swap(nums, start, i);
            if (isBeautiful(nums[start], start)) {
                count += permute(nums, start - 1);
            }
            swap(nums, i, start);
        }
        
        return count;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static boolean isBeautiful(int num, int i) {
        return num % i == 0 || i % num == 0;
    }
}
