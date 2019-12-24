package src.java.contest.weekly168;
/*
 * 1295. Find Numbers with Even Number of Digits (Easy)
 */

public class Q1295 {
    public static void main(String[] args) {
        int[] nums = { 12, 345, 2, 6, 7806 };
        System.out.println(findNumbers(nums));
    }

    public static int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            String str = Integer.toString(num);
            if (str.length() % 2 == 0) {
                res++;
            }
        }
        return res;
    }
}