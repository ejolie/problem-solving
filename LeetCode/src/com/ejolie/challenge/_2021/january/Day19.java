package com.ejolie.challenge._2021.january;

import static org.junit.Assert.assertEquals;

/**
 * Day19. Longest Palindromic Substring
 */
public class Day19 {

    public static void main(String[] args) {
        assertEquals("bb", longestPalindrome_twoPointer("abb"));
        assertEquals("bb", longestPalindrome_twoPointer("bb"));
        assertEquals("aba", longestPalindrome_twoPointer("babad"));
        assertEquals("bb", longestPalindrome_twoPointer("cbbd"));
        assertEquals("a", longestPalindrome_twoPointer("a"));
        assertEquals("a", longestPalindrome_twoPointer("ac"));
        assertEquals("a", longestPalindrome_twoPointer("abc"));
    }

    // - time: O(n^2)
    // - space: O(1)
    public static String longestPalindrome_twoPointer(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            // case 1. "racecar"
            int len1 = expandFromMiddle(s, i, i);
            // case 2. "aabbaa"
            int len2 = expandFromMiddle(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }

        return s.substring(start, end + 1);
    }

    public static int expandFromMiddle(String s, int left, int right) {
        if (s == null || left > right) {
            return 0;
        }

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    // - time: O(n^2)
    // - space: O(n^2)
    public static String longestPalindrome_dp(String s) {
        // Corner cases
        if (s.length() <= 1) {
            return s;
        }

        int N = s.length();
        int maxStart = 0;
        int maxEnd = 0;
        int maxLength = 0;
        // state[i][j] true if s[i, j] is palindrome
        boolean[][] state = new boolean[N][N];

        // Base cases
        for (int i = 0; i < N; i++) {
            state[i][i] = true; // dist = 0;
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int dist = 1; dist < N - i; dist++) {
                int j = i + dist;
                if (dist == 1 && s.charAt(i) == s.charAt(j)) {
                    state[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j)) {
                    state[i][j] = state[i + 1][j - 1];
                }

                if (state[i][j] && maxLength < j - i + 1) {
                    maxLength = j - i + 1;
                    maxStart = i;
                    maxEnd = j;
                }
            }
        }

        return s.substring(maxStart, maxEnd + 1);
    }
}
