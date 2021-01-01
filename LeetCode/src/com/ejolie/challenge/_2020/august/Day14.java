package com.ejolie.challenge._2020.august;

import java.util.HashSet;
import java.util.Set;

/**
 * Day14. Longest Palindrome
 */
public class Day14 {
    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }

    public static int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) set.remove(s.charAt(i));
            else set.add(s.charAt(i));
        }

        int odd = set.size();
        if (odd == 0) return s.length();
        return s.length() - odd + 1;
    }
}
