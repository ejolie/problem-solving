package com.ejolie.challenge._2020.may;

import java.util.HashSet;
import java.util.Set;

/**
 * Day2. Jewels and Stones
 */
public class Day2 {
    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        System.out.println(numJewelsInStones2(J, S));
    }

    private static int numJewelsInStones(String J, String S) {
        int cnt = 0;
        Set<Character> setJ = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            setJ.add(J.charAt(i));
        }
        for (int i = 0; i < S.length(); i++) {
            if (setJ.contains(S.charAt(i))) {
                cnt++;
            }
        }
        return cnt;
    }

    private static int numJewelsInStones2(String J, String S) {
        int[] freq = new int[58];
        int cnt = 0;
        for (int i = 0; i < J.length(); i++) {
            freq[J.charAt(i) - 'A']++;
        }
        for (int i = 0; i < S.length(); i++) {
            if (freq[S.charAt(i) - 'A'] > 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
