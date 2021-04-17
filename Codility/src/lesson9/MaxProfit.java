package lesson9;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxProfit {

    public static void main(String[] args) {
        MaxProfit solution = new MaxProfit();
        assertEquals(354, solution.solution(new int[]{23171, 21011, 21123, 21366, 21013, 21367}));
    }

    // Method 1.
    // - Day Q 에서의 max profit = A[Q] - min(A[0], A[1], ..., A[Q-1])
    // - time: O(n)
    public int solution(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int minPrice = A[0];
        for (int q = 1; q < A.length; q++) {
            int localProfit = A[q] - minPrice;
            maxProfit = Math.max(maxProfit, localProfit);
            minPrice = Math.min(minPrice, A[q]);
        }
        return maxProfit;
    }

    // Method 2.
    // - 66%
    // - time: O(n^2)
    public int solution_quadratic(int[] A) {
        int maxProfit = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int profit = A[j] - A[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }
}
