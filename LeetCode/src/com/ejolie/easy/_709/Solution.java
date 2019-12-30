package com.ejolie.easy._709;

/*
 * 709. To Lower Case
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "al$%phaBET";
        System.out.println(solution.toLowerCase(str));
    }

    private String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch <= 90 && ch >= 65) sb.append((char) (ch + 32));
            else sb.append(ch);
        }
        return sb.toString();
    }
}
