package com.ejolie.easy._28;

/*
 * 28. Implement strStr() @ C (= indexOf() @ Java)
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String haystack = "aaa";
        String needle = "aaaa";
        System.out.println(solution.strStr(haystack, needle));
    }

    private int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        if (nLen == 0) {
            return 0;
        }
        for (int i = 0; i < hLen - nLen + 1; i++) {
            int j = 0;
            for (; j < nLen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == nLen) {
                return i;
            }
        }
        return -1;
    }
}
