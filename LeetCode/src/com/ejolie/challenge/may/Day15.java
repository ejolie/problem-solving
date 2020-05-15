package com.ejolie.challenge.may;

/**
 * Day15. Maximum Sum Circular Subarray
 */
public class Day15 {
    public static void main(String[] args) {
        int[] A = {5, -3, 5};
        System.out.println(maxSubarraySumCircular(A));
    }

    public static int maxSubarraySumCircular(int[] A) {
        if (A.length == 0) return 0;

        int sum = A[0];
        int maxSoFar = A[0], maxTotal = A[0];
        int minSoFar = A[0], minTotal = A[0];
        for (int i = 1; i < A.length; i++) {
            int num = A[i];
            maxSoFar = Math.max(num, maxSoFar + num);
            maxTotal = Math.max(maxSoFar, maxTotal);

            minSoFar = Math.min(num, minSoFar + num);
            minTotal = Math.min(minTotal, minSoFar);

            sum += num;
        }

        if (sum == minSoFar) return maxTotal;
        return Math.max(sum - minTotal, maxTotal);
    }
}
