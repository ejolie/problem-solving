package com.ejolie.easy._9;

/*
 * 9. Palindrome Number
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int x = 121;
        System.out.println(solution.isPalindrome(x));
    }

    // 1. Without Integer -> String (cf. Q7)
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int original = x;
        int res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res == original;
    }

    // 2. Integer -> String
    public boolean isPalindrome2(int x) {
        String str = String.valueOf(x);
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
