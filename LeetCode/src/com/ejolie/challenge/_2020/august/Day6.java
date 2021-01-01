package com.ejolie.challenge._2020.august;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Day6. Find All Duplicates in an Array
 */
public class Day6 {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = findDuplicates(nums);
        System.out.println(result.toString());
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                answer.add(nums[i]);
            }
        }
        return answer;
    }
}
