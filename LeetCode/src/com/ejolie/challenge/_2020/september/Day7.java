package com.ejolie.challenge._2020.september;

import java.util.HashMap;
import java.util.Map;

/**
 * Day7. Word Pattern
 */
public class Day7 {
    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog dog dog dog";
        System.out.println(wordPattern(pattern, str));
    }

    public static boolean wordPattern(String pattern, String str) {
        int N = pattern.length();
        Map<Character, String> map = new HashMap<>();
        String[] words = str.split(" ");
        if (words.length != N) return false;

        for (int i = 0; i < N; i++) {
            char key = pattern.charAt(i);
            String value = map.getOrDefault(key, "");
            if (map.containsKey(key)) {
                if (!value.equals(words[i])) return false;
            } else {
                if (map.containsValue(words[i])) return false;
                map.put(key, words[i]);
            }
        }

        return true;
    }
}
