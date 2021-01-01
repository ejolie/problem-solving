package com.ejolie.challenge._2020.september;

import java.util.ArrayList;
import java.util.List;

/**
 * Day4. Partition Labels
 */
public class Day4 {
    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(S).toString());
    }

    /**
     * 1. Greedy
     * - Time: O(n)
     * - Space: O(1)
     */
    public static List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) return null;

        List<Integer> answer = new ArrayList<>();
        int[] lastIndex = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastIndex[S.charAt(i) - 'a'] = i;
        }

        int last = 0;
        int start = 0;
        for (int i = 0; i < S.length(); i++) {
            last = Math.max(last, lastIndex[S.charAt(i) - 'a']);
            if (last == i) {
                answer.add(last - start + 1);
                start = last + 1;
            }
        }
        return answer;
    }
}
