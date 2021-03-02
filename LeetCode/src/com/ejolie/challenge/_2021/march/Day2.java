package com.ejolie.challenge._2021.march;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertArrayEquals;

/**
 * Day2. Set Mismatch
 */
public class Day2 {
    public static void main(String[] args) {
        assertArrayEquals(new int[]{2, 3}, findErrorNums_hashSet(new int[]{1, 2, 2, 4}));
        assertArrayEquals(new int[]{1, 2}, findErrorNums(new int[]{1, 1}));
    }

    public static int[] findErrorNums(int[] nums) {
        int N = nums.length;
        int[] counter = new int[N + 1];
        for (int num : nums) {
            counter[num]++;
        }

        int[] answer = new int[2];
        for (int num = 1; num <= N; num++) {
            if (counter[num] > 1) {
                answer[0] = num;
            } else if (counter[num] == 0) {
                answer[1] = num;
            }
            if (answer[0] != 0 && answer[1] != 0) {
                break;
            }
        }
        return answer;
    }

    public static int[] findErrorNums_hashSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int N = nums.length;
        int duplicate = 0;
        long sum = ((long) N * (N + 1)) / 2;
        for (int num : nums) {
            if (set.contains(num)) {
                duplicate = num;
            }
            sum -= num;
            set.add(num);
        }
        return new int[]{duplicate, (int) sum + duplicate};
    }
}
