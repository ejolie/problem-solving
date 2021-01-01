package com.ejolie.challenge._2020.september;

/**
 * Day3. Repeated Substring Pattern
 */
public class Day3 {
    public static void main(String[] args) {
//        System.out.println(repeatedSubstringPattern("abab"));
//        System.out.println(repeatedSubstringPattern("aba"));
//        System.out.println(repeatedSubstringPattern("abcabcabcabc"));
//        System.out.println(repeatedSubstringPattern("bb"));
//        System.out.println(repeatedSubstringPattern("ababba"));
        System.out.println(repeatedSubstringPattern("babbabbabbabbab"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        int N = s.length();

        for (int len = N / 2; len >= 1; len--) {
            if (N % len != 0) continue;

            int M = s.length() / len;
            String str = s.substring(0, len);
            int j = 1;

            for (; j < M; j++) {
                if (!str.equals(s.substring(j * len, (j + 1) * len))) break;
            }

            if (j == M) return true;
        }

        return false;
    }
}
