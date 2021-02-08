package com.ejolie.challenge._2021.february;

import java.util.TreeSet;

import static org.junit.Assert.assertArrayEquals;


/**
 * Day7. Shortest Distance to a Character
 */
public class Day7 {
    public static void main(String[] args) {
        assertArrayEquals(new int[]{3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0}, shortestToChar_twoPass("loveleetcode", 'e'));
    }

    public static int[] shortestToChar_twoPass(String s, char c) {
        int N = s.length();
        int[] result = new int[N];
        int prev = -10000;

        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            result[i] = i - prev;
        }

        prev = 10000;
        for (int i = N - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            result[i] = Math.min(result[i], prev - i);
        }

        return result;
    }

    public static int[] shortestToChar_treeSet(String s, char c) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                treeSet.add(i);
            }
        }

        int[] result = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != c) {
                int ceiling = 10000, floor = -10000;
                if (i <= treeSet.last()) {
                    ceiling = treeSet.ceiling(i);
                }
                if (i >= treeSet.first()) {
                    floor = treeSet.floor(i);
                }
                result[i] = Math.min(ceiling - i, i - floor);
            }
        }

        return result;
    }
}
