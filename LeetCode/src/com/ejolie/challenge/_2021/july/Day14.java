package com.ejolie.challenge._2021.july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Day14. Custom Sort String
 */
public class Day14 {

    public static void main(String[] args) {
        System.out.println(customSortString("cba", "abcd"));
    }

    public static String customSortString(String order, String str) {
        int[] orderNumber = new int[26];
        Arrays.fill(orderNumber, -1);
        for (int i = 0; i < order.length(); i++) {
            orderNumber[order.charAt(i) - 'a'] = i;
        }

        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            chars.add(str.charAt(i));
        }
        chars.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return orderNumber[o1 - 'a'] - orderNumber[o2 - 'a'];
            }
        });

        StringBuilder result = new StringBuilder();
        for (Character ch : chars) {
            result.append(ch);
        }
        return result.toString();
    }
}
