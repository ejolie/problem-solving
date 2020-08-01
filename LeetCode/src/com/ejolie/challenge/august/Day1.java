package com.ejolie.challenge.august;

/**
 * Day1. Detect Capital
 */
public class Day1 {
    public static void main(String[] args) {
        String word = "g";
        System.out.println(detectCapitalUse(word));
    }

    public static boolean detectCapitalUse(String word) {
        boolean isAllUpper = Character.isUpperCase(word.charAt(0));
        boolean isAllLower = Character.isLowerCase(word.charAt(0));
        boolean isFirstUpper = Character.isUpperCase(word.charAt(0));
        for (int i = 1; i < word.length(); i++) {
            isAllUpper &= Character.isUpperCase(word.charAt(i));
            isAllLower &= Character.isLowerCase(word.charAt(i));
            isFirstUpper &= Character.isLowerCase(word.charAt(i));
        }
        return isAllUpper || isAllLower || isFirstUpper;
    }
}
