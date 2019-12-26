package com.ejolie.medium._12;

import java.util.HashMap;
import java.util.LinkedHashMap;

/*
 * 12. Integer to Roman
 */
public class Solution {
    private LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

    Solution() {
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int num = 1994;
        System.out.println(solution.intToRoman(num));
    }

    // 1. LinkedHashMap
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();

        for (String key : map.keySet()) {
            if (num == 0) {
                break;
            }
            int value = map.get(key);
            int div = num / value;
            if (div == 0) {
                continue;
            }
            while (div > 0) {
                res.append(key);
                num -= value;
                div--;
            }
        }

        return res.toString();
    }

    // 2. Two arrays
    public String intToRoman2(int num) {
        StringBuilder res = new StringBuilder();
        int[] div = {1000, 900, 500, 400, 100, 90,
                50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC",
                "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < div.length;) {
            if (num >= div[i]) {
                res.append(roman[i]);
                num -= div[i];
            } else {
                i++;
            }
        }

        return res.toString();
    }
}
