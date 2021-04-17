package lesson9;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxSliceSum {

    public static void main(String[] args) {
        MaxSliceSum solution = new MaxSliceSum();
        assertEquals(5, solution.solution(new int[]{3, 2, -6, 4, 0}));
        assertEquals(4, solution.solution(new int[]{3, -2, 3}));
    }

    // Method 1. Kadane’s Algorithm
    // - i 까지의 최대 합 = max(i-1 까지의 최대 합 + A[i], A[i])
    // - time: O(n)
    public int solution(int[] A) {
        long localMax = A[0];
        long globalMax = A[0];
        for (int i = 1; i < A.length; i++) {
            localMax = Math.max(localMax + A[i], A[i]);
            globalMax = Math.max(globalMax, localMax);
        }
        return (int) globalMax;
    }

    // Method 2.
    // - time: O(n^2)
    public int solution_quadratic(int[] A) {
        long maxSum = Long.MIN_VALUE;
        for (int left = 0; left < A.length; left++) {
            long sum = 0;
            for (int right = left; right < A.length; right++) {
                sum += A[right];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return (int) maxSum;
    }
}
