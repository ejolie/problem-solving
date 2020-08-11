package com.ejolie.challenge.august;

/**
 * Day10. Excel Sheet Column Number
 */
public class Day10 {
    public static void main(String[] args) {
        System.out.println(titleToNumber("AA"));
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("BA"));
        System.out.println(titleToNumber("ZY"));
        System.out.println(titleToNumber("FXSHRXW"));
    }

    public static int titleToNumber(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            answer = answer * 26 + (s.charAt(i) - 'A' + 1);
        }
        return answer;
    }
}
