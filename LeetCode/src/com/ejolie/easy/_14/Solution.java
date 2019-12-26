package com.ejolie.easy._14;

/*
 * 14. Longest Common Prefix
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String[] strs = {"flower", "flow", "flight"};
        String[] strs = {"dog" ,"racecar", "car"};
        System.out.println(solution.longestCommonPrefix(strs));
    }

    // 0. Character by character matching
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int minlen = findMinLength(strs);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < minlen; i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != ch) {
                    return sb.toString();
                }
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    public int findMinLength(String[] strs) {
        int minlen = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minlen) {
                minlen = strs[i].length();
            }
        }
        return minlen;
    }

    // 1. Horizontal scanning
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    // 2. Vertical scanning
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != ch) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    // 3. Divide and conquer

    // 4. Binary search
}
