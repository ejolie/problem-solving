package src.contest.weekly168;
/*
 * 1296. Divide Array in Sets of K Consecutive Numbers Medium
 * Medium
 */

import java.util.Arrays;
import java.util.HashMap;

public class Q1296 {
    public static void main(String[] args) {
        int[] nums = { 15, 16, 17, 18, 19, 16, 17, 18, 19, 20, 6, 7, 8, 9, 10, 3, 4, 5, 6, 20 };
        int k = 5;
        System.out.println(isPossibleDivide(nums, k));
    }

    public static boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                int value = map.get(num);
                map.put(num, ++value);
            } else {
                map.put(num, 1);
            }
        }

        return true;
    }
}