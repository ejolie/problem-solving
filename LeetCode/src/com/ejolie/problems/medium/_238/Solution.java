package com.ejolie.problems.medium._238;

import static org.junit.Assert.assertArrayEquals;

/**
 * 238. Product of Array Except Self
 * <p>
 * a[0] =        a[1] * a[2] * a[3] * a[4]
 * a[1] = a[0]        * a[2] * a[3] * a[4]
 * a[2] = a[0] * a[1]        * a[3] * a[4]
 * a[3] = a[0] * a[1] * a[2]        * a[4]
 * a[4] = a[0] * a[1] * a[2] * a[3]
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        assertArrayEquals(new int[]{0, 0, 9, 0, 0}, solution.productExceptSelf_bruteForce(new int[]{-1, 1, 0, -3, 3}));
        assertArrayEquals(new int[]{0, 0, 9, 0, 0}, solution.productExceptSelf(new int[]{-1, 1, 0, -3, 3}));
        assertArrayEquals(new int[]{24, 12, 8, 6}, solution.productExceptSelf(new int[]{1, 2, 3, 4}));
        assertArrayEquals(new int[]{0, 0, 0, 0, 0}, solution.productExceptSelf(new int[]{1, 2, 0, 3, 0}));
    }

    public int[] productExceptSelf_bruteForce(int[] nums) {
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                product *= nums[j];
            }
            answer[i] = product;
        }
        return answer;
    }

    public int[] productExceptSelf(int[] nums) {
        int allProduct = 1;
        int zeroCount = 0;
        int zeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            allProduct *= nums[i];
            if (nums[i] == 0) {
                zeroCount++;
                zeroIndex = i;
            }
        }

        int[] answer = new int[nums.length];
        if (zeroCount == 1) {
            allProduct = 1;
            for (int i = 0; i < nums.length; i++) {
                if (i == zeroIndex) {
                    continue;
                }
                allProduct *= nums[i];
            }
            answer[zeroIndex] = allProduct;
        } else if (zeroCount == 0) {
            for (int i = 0; i < nums.length; i++) {
                answer[i] = allProduct / nums[i];
            }
        }
        return answer;
    }
}
