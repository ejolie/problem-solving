package com.ejolie.easy._1295;

/*
 * 1295. Find Numbers with Even Number of Digits
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 12, 345, 2, 6, 7806 };
        System.out.println(solution.findNumbers(nums));
    }

    public int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            String str = Integer.toString(num);
            if (str.length() % 2 == 0) {
                res++;
            }
        }
        return res;
    }
}
