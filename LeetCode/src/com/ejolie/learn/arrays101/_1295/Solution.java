package com.ejolie.learn.arrays101._1295;

/**
 * 1295. Find Numbers with Even Number of Digits
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {555, 901, 482, 1771};
        System.out.println(findNumbers(nums));
    }

    private static int findNumbers(int[] nums) {
        int cnt = 0;
        for (int num : nums) {
            cnt += checkDigit(num);
        }
        return cnt;
    }

    private static int checkDigit(int num) {
        int digit = 0;
        while (num > 0) {
            digit++;
            num /= 10;
        }
        return (digit & 1) == 0 ? 1 : 0;
    }
}
