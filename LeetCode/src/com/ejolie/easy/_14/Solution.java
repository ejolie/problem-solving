package com.ejolie.easy._14;

/*
 * 14. Longest Common Prefix
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"flower", "flow", "flight"};
//        String[] strs = {"dog" ,"racecar", "car"};
        System.out.println(solution.longestCommonPrefix3(strs));
    }

    // TODO: Understanding other solutions
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
//        int minlen = strs[0].length();
//        for (int i = 1; i < strs.length; i++) {
//            if (strs[i].length() < minlen) {
//                minlen = strs[i].length();
//            }
//        }
//        return minlen;
        int minlen = Integer.MAX_VALUE;
        for (String str : strs) {
            minlen = Math.min(minlen, str.length());
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
    public String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return longestCommonPrefix4(strs, 0, strs.length-1);
    }

    private String longestCommonPrefix4(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }

        int mid = (l + r) / 2;
        String lcpLeft = longestCommonPrefix4(strs, l, mid);
        String lcpRight = longestCommonPrefix4(strs, mid + 1, r);
        return commonPrefix(lcpLeft, lcpRight);
    }

    String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }

    // 4. Binary search
    public String longestCommonPrefix5(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }

        int low = 1, high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle)) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len) {
        String str1 = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(str1)) {
                return false;
            }
        }
        return true;
    }

    // 5. Trie
}
