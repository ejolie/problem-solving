package com.ejolie.challenge._2021.july;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Day12. Isomorphic Strings
 */
public class Day12 {

    public static void main(String[] args) {
        assertTrue(isIsomorphic("egg", "add"));
        assertTrue(isIsomorphic("egg", "egg"));
        assertTrue(isIsomorphic("paper", "title"));
        assertFalse(isIsomorphic("foo", "bar"));
        assertFalse(isIsomorphic("badc", "baba"));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (!sMap.containsKey(sChar)) {
                if (tMap.containsKey(tChar) && tMap.get(tChar) != sChar) {
                    return false;
                }
                sMap.put(sChar, tChar);
                tMap.put(tChar, sChar);
            } else if (sMap.get(sChar) != tChar) {
                return false;
            }
        }
        return true;
    }
}
