package com.ejolie.challenge._2020.may;

import java.util.*;

/**
 * Day5. First Unique Character in a String
 */
public class Day5 {
    public static void main(String[] args) {
        String s = "oveleetcode";
        System.out.println(firstUniqChar2(s));
    }

    private static int firstUniqChar(String s) {
        int[] freq = new int[26];
        int len = s.length();

        for (int i = 0; i < len; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < len; i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    private static int firstUniqChar2(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (set.contains(ch)) {
                map.remove(ch);
            } else {
                map.put(ch, i);
                set.add(ch);
            }
        }

        return map.size() == 0 ? -1 : map.entrySet().iterator().next().getValue();
    }
}
