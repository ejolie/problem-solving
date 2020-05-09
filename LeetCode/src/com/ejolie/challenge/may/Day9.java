package com.ejolie.challenge.may;

/**
 * Day9. Valid Perfect Square
 */
public class Day9 {
    public static void main(String[] args) {
        int num = 14;
        System.out.println(isPerfectSquare(num));
    }

    private static boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
