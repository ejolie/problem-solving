package com.ejolie.challenge._2021.january;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;

/**
 * Day21. Find the Most Competitive Subsequence
 * cf. [프로그래머스] 탐욕법 - 큰 수 만들기
 */
public class Day21 {
    public static void main(String[] args) {
        assertArrayEquals(new int[]{2, 6}, mostCompetitive_stack(new int[]{3, 5, 2, 6}, 2));
        assertArrayEquals(new int[]{2, 3, 3, 4}, mostCompetitive_stack(new int[]{2, 4, 3, 3, 5, 4, 9, 6}, 4));
        assertArrayEquals(new int[]{8, 80, 2},
                mostCompetitive_stack(new int[]{71, 18, 52, 29, 55, 73, 24, 42, 66, 8, 80, 2}, 3));
    }

    // - time: O(n)
    // - space: O(k)
    public static int[] mostCompetitive_stack(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[k];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[i] < nums[stack.peek()] && nums.length - i + stack.size() > k) {
                stack.pop();
            }

            if (stack.size() < k) {
                stack.push(i);
            }
        }

        for (int i = k - 1; i >= 0; i--) {
            result[i] = nums[stack.pop()];
        }

        return result;
    }

    // time limit exception
    public static int[] mostCompetitive_bruteForce(int[] nums, int k) {
        List<List<Integer>> pairs = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        combine(pairs, temp, 0, nums, k);

        pairs.sort((a, b) -> {
            for (int i = 0; i < k; i++) {
                if (a.get(i) < b.get(i)) {
                    return -1;
                } else if (a.get(i) > b.get(i)) {
                    return 1;
                }
            }
            return 0;
        });

        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = pairs.get(0).get(i);
        }

        return answer;
    }

    private static void combine(List<List<Integer>> pairs, List<Integer> temp, int start, int[] nums, int k) {
        if (temp.size() == k) {
            pairs.add(new LinkedList<>(temp));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            combine(pairs, temp, i + 1, nums, k);
            temp.remove(temp.size() - 1);
        }
    }
}
