package com.ejolie.problems.easy._409;

import java.util.HashSet;
import java.util.Set;

/**
 * 409. Longest Palindrome
 */
public class Solution {
    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }

    public static int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) set.remove(s.charAt(i));
            else set.add(s.charAt(i));
        }

        int odd = set.size();
        return s.length() - (odd == 0 ? 0 : odd - 1);
    }

    public static int longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        int odd = 0;
        for (int c : count) {
            if (c % 2 != 0) {
                odd++;
            }
        }
        return odd == 0 ? s.length() : s.length() - odd + 1;
    }
}
