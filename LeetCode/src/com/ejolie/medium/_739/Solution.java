package com.ejolie.medium._739;

import java.util.*;

/*
 * 739. Daily Temperatures
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(solution.dailyTemperatures2(T)));
    }

    // 0. Stack
    public int[] dailyTemperatures(int[] T) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && stack.peek()[1] < T[i]) {
                int[] t = stack.pop();
                res[t[0]] = i - t[0];
            }
            stack.push(new int[]{i, T[i]});
        }
        return res;
    }

    // 1. Next Array - O(n * w)
    // n : the length of T
    // w : the number of allowed values of T[i]
    public int[] dailyTemperatures2(int[] T) {
        int[] ans = new int[T.length];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        for (int i = T.length - 1; i >= 0; --i) {
            int warmer_index = Integer.MAX_VALUE;
            for (int t = T[i] + 1; t <= 100; ++i) {
                if (next[t] < warmer_index) {
                    warmer_index = next[t];
                }
            }
            if (warmer_index < Integer.MAX_VALUE) {
                ans[i] = warmer_index - i;
            }
            next[T[i]] = i;
        }
        return ans;
    }

    // 2. Stack - O(n)
    public int[] dailyTemperatures3(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }

}
