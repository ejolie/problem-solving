package com.ejolie.challenge._2021.february;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

/**
 * Day4. Longest Harmonious Subsequence
 */
public class Day4 {
    public static void main(String[] args) {
        assertEquals(5, findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
        assertEquals(2, findLHS(new int[]{1, 2, 3, 4}));
        assertEquals(0, findLHS(new int[]{1, 1, 1, 1}));
        assertEquals(4, findLHS(new int[]{-3, -1, -1, -1, -3, -2}));
        assertEquals(15, findLHS(new int[]
                {0, 3, 1, 3, 3, 3, 0, 1, 0, 2, 0, 3, 1, 3, -3, 2, 0, 3, 1, 2, 2, -3, 2, 2, 3, 3}));
    }

    public static int findLHS(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        int prevNum = Integer.MIN_VALUE;
        int maxLength = 0;
        for (int num : map.keySet()) {
            if (Math.abs(num - prevNum) == 1) {
                maxLength = Math.max(maxLength, map.get(prevNum) + map.get(num));
            }
            prevNum = num;
        }

        return maxLength;
    }

    public static int findLHS_hashMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        int maxLength = 0;
        for (int num : map.keySet()) {
            if (map.containsKey(num + 1)) {
                maxLength = Math.max(maxLength, map.get(num) + map.get(num + 1));
            }
        }

        return maxLength;
    }
}
