package com.ejolie.challenge.july;

/**
 * Day26. Add Digits
 */
public class Day26 {
    public static void main(String[] args) {
        int num = 38;
        System.out.println(addDigits(num));
    }

    // 1. Brute Force
    public static int addDigits(int num) {
        if (num < 10) return num;
        while (num > 9) {
            int sum = digitSum(num);
            num = sum;
        }
        return num;
    }

    private static int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    // 2. Math
    public static int addDigits2(int num) {
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
    }
}
