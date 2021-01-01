package com.ejolie.challenge._2020.may;

import java.util.*;

/**
 * Day3. Ransom Note
 */
public class Day3 {
    public static void main(String[] args) {
        String ransomNote = "fffbfg";
        String magazine = "effjfggbffjdgbjjhhdegh";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            freq[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (--freq[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean canConstruct2(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : magazine.toCharArray()) {
            int newCnt = map.getOrDefault(ch, 0) + 1;
            map.put(ch, newCnt);
        }

        for (char ch : ransomNote.toCharArray()) {
            int newCnt = map.getOrDefault(ch, 0) - 1;
            if (newCnt < 0) {
                return false;
            }
            map.put(ch, newCnt);
        }

        return true;
    }
}
