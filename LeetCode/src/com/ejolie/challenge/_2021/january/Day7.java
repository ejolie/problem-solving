package com.ejolie.challenge._2021.january;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Day7. Longest Substring Without Repeating Characters
 */
public class Day7 {
    public static void main(String[] args) {
        assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, lengthOfLongestSubstring("pwwkew"));
        assertEquals(0, lengthOfLongestSubstring(""));
        assertEquals(3, lengthOfLongestSubstring("dvdf"));
        assertEquals(5, lengthOfLongestSubstring("anviaj"));
        assertEquals(2, lengthOfLongestSubstring("abba"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return s.length();
        }

        int l = 0, r = 0;
        int maxLen = 0;
        Set<Character> set = new HashSet<>();
        while (r < s.length() && maxLen < s.length() - r) {
            while (r < s.length() && !set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
            }

            maxLen = Math.max(maxLen, r - l);
            r = ++l;
            set = new HashSet<>();
        }

        return maxLen;
    }

    // sliding window
    public static int lengthOfLongestSubstring_slidingWindow(String s) {
        int N = s.length();
        int max = 0;
        int l = 0, r = 0;
        Set<Character> set = new HashSet<>(); // check existence of character

        while (l < N && r < N) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(r))) {
                set.add(s.charAt(r++));
                max = Math.max(max, r - l);
            } else {
                set.remove(s.charAt(l++));
            }
        }

        return max;
    }

    // sliding window optimized
    public static int lengthOfLongestSubstring_slidingWindowOptimized(String s) {
        int N = s.length();
        int max = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character

        // try to extend the range [i, j]
        for (int l = 0, r = 0; r < N; r++) {
            if (map.containsKey(s.charAt(r))) {
                l = Math.max(map.get(s.charAt(r)), l);
            }
            max = Math.max(max, r - l + 1);
            map.put(s.charAt(r), r + 1);
        }

        return max;
    }

}
