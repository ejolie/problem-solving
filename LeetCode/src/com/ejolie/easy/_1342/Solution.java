package com.ejolie.easy._1342;

/*
 * 1342. Number of Steps to Reduce a Number to Zero
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int num = 123;
        System.out.println(solution.numberOfSteps(num));
    }

    public int numberOfSteps (int num) {
        int cnt = 0;
        while (num != 0) {
            if (num % 2 == 1) {
                num--;
            } else {
                num /= 2;
            }
            cnt++;
        }
        return cnt;
    }
}
