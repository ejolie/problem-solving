package src.java.problems;

/*
 * 136. Single Number (Easy)
 */
import java.util.Arrays;

public class Q136 {
    public static void main(String[] args) {
        int[] nums = { 4, 1, 2, 1, 2 };
        // int[] nums = { 1, 1, 3, 3, 4, 5, 5 };
        System.out.println(singleNumber(nums));
    }

    // 1. Arrays.sort() and Compare prev & next
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    // 2. XOR
    // a ^ 0 = a
    // a ^ a = 0
    public static int singleNumber2(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    // 3. Arrays.stream()
    public static int singleNumber3(int[] nums) {
        return Arrays.stream(nums).reduce((a, b) -> a ^ b).getAsInt();
    }
}
