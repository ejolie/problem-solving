package binary_search;

import java.util.Arrays;

/**
 * 예산
 */
public class pg_43237 {
    public static void main(String[] args) {
        int[] budgets = {120, 110, 140, 150};
        int M = 485;
        System.out.println(solution(budgets, M));
    }

    public static int solution(int[] budgets, int M) {
        Arrays.sort(budgets);

        int len = budgets.length;
        int lo = 1;
        int hi = budgets[len - 1];
        int ans = 0;
        while (lo <= hi) {
            int mid = lo + hi >> 1;
            long budgetSum = _sum(mid, budgets, len);

            if (budgetSum < M) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }

    private static long _sum(int mid, int[] budgets, int len) {
        long sum = 0;
        for (int i = 0; i < len; i++) {
            int budget = budgets[i];
            sum += Math.min(budget, mid);
        }
        return sum;
    }
}
