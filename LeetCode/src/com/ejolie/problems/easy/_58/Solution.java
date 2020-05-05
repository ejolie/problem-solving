package com.ejolie.problems.easy._58;
/*
 * 58. Length of Last Word
 */

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = " Hello World     ";
        System.out.println(solution.lengthOfLastWord(s));
    }

    // 0. String.split()
    public int lengthOfLastWord(String s) {
        String[] strs = s.split(" ");
        if (strs.length == 0) return 0;
        return strs[strs.length - 1].length();
    }

    public int lengthOfLastWord2(String s) {
        int len = s.length(), lastLength = 0;
        while (len > 0 && s.charAt(len - 1) == ' ') {
            len--;
        }
        while (len > 0 && s.charAt(len - 1) != ' ') {
            lastLength++;
            len--;
        }
        return lastLength;
    }

    public int lengthOfLastWord3(String s) {
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (len != 0) return len;
            } else {
                len++;
            }
        }
        return len;
    }

    // 4. String.trim() + String.lastIndexOf()
    public int lengthOfLastWord4(String s) {
        s = s.trim();
        int lastIndex = s.lastIndexOf(' ') + 1;
        return s.length() - lastIndex;
    }
}
