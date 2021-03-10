package com.ejolie.challenge._2021.march;

import static org.junit.Assert.assertEquals;

/**
 * Day10. Integer to Roman
 */
public class Day10 {
    public static void main(String[] args) {
        assertEquals("III", intToRoman(3));
        assertEquals("IV", intToRoman(4));
        assertEquals("IX", intToRoman(9));
        assertEquals("LVIII", intToRoman(58));
        assertEquals("MCMXCIV", intToRoman(1994));
        assertEquals("MMMCMXCIX", intToRoman(3999));
    }

    public static String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return "";
        }

        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder result = new StringBuilder();
        int i = 0;
        while (num > 0) {
            while (num >= values[i]) {
                num -= values[i];
                result.append(roman[i]);
            }
            i++;
        }
        
        return result.toString();
    }
}
