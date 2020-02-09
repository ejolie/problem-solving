package com.ejolie.medium._1343;

/*
 * 1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2,2,2,2,5,5,5,8};
        int k = 3, threshold = 4;
        System.out.println(solution.numOfSubarrays(arr, k, threshold));
    }

    // sub-array
    // 1) k개의 숫자를 가진
    // 2) 평균 값이 threshold 보다 크거나 같은
    // => k개 숫자의 합이 k * threshold 보다 크거나 같은
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int cnt = 0, sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        if (sum >= k * threshold) cnt++;
        for (int i = 1; i < arr.length - k + 1; i++) {
            sum = sum - arr[i - 1] + arr[i + k - 1];
            if (sum >= k * threshold) cnt++;
        }
        return cnt;
    }
}
