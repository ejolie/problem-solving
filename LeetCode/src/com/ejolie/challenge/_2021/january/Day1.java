package com.ejolie.challenge._2021.january;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Day1. Check Array Formation Through Concatenation
 */
public class Day1 {
    public static void main(String[] args) {
        assertTrue(canFormArray_hashmap(new int[]{85}, new int[][]{{85}}));
        assertTrue(canFormArray_hashmap(new int[]{15, 88}, new int[][]{{88}, {15}}));
        assertFalse(canFormArray_hashmap(new int[]{49, 18, 16}, new int[][]{{16, 18, 49}}));
        assertTrue(canFormArray_hashmap(new int[]{91, 4, 64, 78}, new int[][]{{78}, {4, 64}, {91}}));
        assertFalse(canFormArray_hashmap(new int[]{1, 3, 5, 7}, new int[][]{{2, 4, 6, 8}}));
        assertTrue(canFormArray_hashmap(new int[]{2, 82, 79, 95, 28}, new int[][]{{2}, {82}, {28}, {79, 95}}));
    }

    public static boolean canFormArray_hashmap(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }

        int start = 0;
        while (start < arr.length) {
            if (map.containsKey(arr[start])) {
                int[] piece = map.get(arr[start]);

                for (int i = 0; i < piece.length; i++) {
                    if (arr[start] != piece[i]) {
                        return false;
                    } else {
                        start++;
                    }
                }
            } else {
                return false;
            }
        }

        return true;
    }

    public static boolean canFormArray_hashmap2(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }

        int[] result = new int[arr.length];
        int i = 0;
        for (int a : arr) {
            int[] piece = map.getOrDefault(a, new int[0]);
            for (int p : piece) {
                result[i++] = p;
            }
        }

        return Arrays.equals(arr, result);
    }
}
