package com.ejolie.challenge.july;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Day6. Plus One
 */
public class Day6 {
    public static void main(String[] args) {
        int[] digits = {8};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    public static int[] plusOne(int[] digits) {
        int N = digits.length;
        LinkedList<Integer> list = new LinkedList<>();
        int carry = 0;
        for (int i = N - 1; i >= 0; i--) {
            int num = i == N - 1 ? 1 : 0;
            num += digits[i] + carry;
            carry = num / 10;
            num = num % 10;
            list.addFirst(num);
        }
        if (carry > 0) list.addFirst(carry);
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static int[] plusOne2(int[] digits) {
        int N = digits.length;
        for (int i = N - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newNumber = new int[N + 1];
        newNumber[0] = 1;
        return newNumber;
    }
}
