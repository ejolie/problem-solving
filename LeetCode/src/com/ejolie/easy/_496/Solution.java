package com.ejolie.easy._496;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * 496. Next Greater Element I
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(solution.nextGreaterElement(nums1, nums2)));
    }

    // 0. Brute Force - O(n^2)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int x = nums1[i];
            int j = 0;
            for (; j < nums2.length; j++) {
                if (nums2[j] == x) {
                    break;
                }
            }
            int k = j + 1;
            for (; k < nums2.length; k++) {
                if (nums2[k] > nums2[j]) {
                    res[i] = nums2[k];
                    break;
                }
            }
            if (k == nums2.length) {
                res[i] = -1;
            }
        }
        return res;
    }

    // 1. Use Stack & Hash Map - O(n)
    // - 예를 들어 [5, 4, 3, 2, 1, 6] 처럼 있으면
    //   6은 이전에 나온 모든 숫자들의 next greater element가 된다.
    //   따라서, 내림차순을 유지하기 위해 stack을 사용한다.
    // - stack.peek() 보다 큰 x 를 볼 때마다,
    //   x 보다 작은 모든 숫자들을 pop한다.
    //   pop된 모든 숫자들의 next greater element는 x다.
    public int[] nextGreaterElement2(int[] findNums, int[] nums) {
         Map<Integer, Integer> map = new HashMap<>();
         Stack<Integer> stack = new Stack<>();
         for (int num : nums) {
             while (!stack.isEmpty() && stack.peek() < num) {
                 map.put(stack.pop(), num);
             }
             stack.push(num);
         }
         for (int i = 0; i < findNums.length; i++) {
             findNums[i] = map.getOrDefault(findNums[i], -1);
         }
         return findNums;
    }
}
