package com.ejolie.challenge._2021.february;

import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Day11. Valid Anagram
 */
public class Day11 {
    public static void main(String[] args) {
        assertTrue(isAnagram_array("anagram", "nagaram"));
        assertFalse(isAnagram_array("rat", "car"));
        assertTrue(isAnagram_hashMap("anagram", "nagaram"));
        assertFalse(isAnagram_hashMap("rat", "car"));
    }

    // - time: O(n lg n)
    // - space: O(1) or O(n) -> toCharArray()
    public static boolean isAnagram_array(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }

    // - time: O(n)
    // - space: O(1)
    public static boolean isAnagram_hashArray(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    // if input contains other unicode characters
    public static boolean isAnagram_hashMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }

        for (char c : map.keySet()) {
            if (map.get(c) != 0) {
                return false;
            }
        }

        return true;
    }
}
