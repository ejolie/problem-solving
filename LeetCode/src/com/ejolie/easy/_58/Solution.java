package com.ejolie.easy._58;
/*
 * 58. Length of Last Word
 */

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "Hello World";
        System.out.println(solution.lengthOfLastWord(s));
    }

    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.equals("")) return 0;
        String[] strs = s.split(" ");
        return strs[strs.length - 1].length();
    }
}
