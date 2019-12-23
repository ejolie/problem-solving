package problems;
/*
 * 167. Two Sum II - Input array is sorted
 * Easy
 */

import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

public class Q167 {
    public static void main(String[] args) {
        int[] numbers = { 2, 7, 11, 15 };
        int target = 9;
        twoSum(numbers, target);
    }

    // 1. Same as Q1
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int comp = target - numbers[i];
            if (map.containsKey(comp)) {
                return new int[] { map.get(comp) + 1, i + 1 };
            }
            map.put(numbers[i], i);
        }
        return null;
    }

    // 2. Two pointer search
    public static int[] twoSum2(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int sum = nums[lo] + nums[hi];
        while (sum != target) {
            if (sum < target) {
                lo++;
            } else {
                hi--;
            }
            sum = nums[lo] + nums[hi];
        }
        return new int[] { lo + 1, hi + 1 };
    }

    // 3. Reduce search by Arrays.binarySearch()
    public static int[] twoSum3(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        if (nums[low] >= 0 && target < nums[high]) {
            // Case 1. nums > 0, initialize high <= target
            high = Arrays.binarySearch(nums, target);
            high = high >= 0 ? high : -high - 1;
        } else if (nums[high] <= 0 && target > nums[low]) {
            // Case 2. nums < 0
            low = Arrays.binarySearch(nums, target);
            low = low >= 0 ? low : -low - 1;
        }
        while (low < high) {
            int sum = nums[low] + nums[high];
            if (sum == target) {
                return new int[] { low + 1, high + 1 };
            }
            if (sum > target) {
                high--;
            } else {
                low++;
            }
        }
        throw new IllegalArgumentException("No solution exists");
    }
}