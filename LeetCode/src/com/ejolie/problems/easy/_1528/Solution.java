package com.ejolie.problems.easy._1528;

import static org.junit.Assert.assertEquals;

/**
 * 1528. Shuffle String
 */
public class Solution {
    public static void main(String[] args) {
        assertEquals("leetcode", restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}));
    }

    public static String restoreString(String s, int[] indices) {
        char[] chars = new char[s.length()];
        for (int i = 0; i < indices.length; i++) {
            chars[indices[i]] = s.charAt(i);
        }
        return String.valueOf(chars);
    }
}
