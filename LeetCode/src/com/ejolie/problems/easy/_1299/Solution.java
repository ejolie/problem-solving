package com.ejolie.problems.easy._1299;

import java.util.Arrays;

/*
 * 1299. Replace Elements with Greatest Element on Right Side
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {17,18,5,4,6,1};
        System.out.println(Arrays.toString(solution.replaceElements(arr)));
    }

    private int[] replaceElements(int[] arr) {
        int len = arr.length;
        int[] res = new int[len];
        int max = -1;
        for (int i = len - 1; i >= 0; i--) {
            int temp = arr[i];
            res[i] = max;
            if (temp > max) {
                max = temp;
            }
        }
        return res;
    }
}
