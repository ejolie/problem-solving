package algorithm_practice_kit.dp;

import java.util.Arrays;

/**
 * 카드 게임
 */
public class pg_42896 {
    public static void main(String[] args) {
        int[] left = {3, 2, 5};
        int[] right = {2, 4, 1};
        System.out.println(solution(left, right));
    }

    public static int solution(int[] left, int[] right) {
        int[][] dp = new int[left.length][right.length];
        for (int i = 0; i < left.length; i++) {
            for (int j = 0; j < right.length; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(0, 0, left, right, dp);
    }

    private static int solve(int li, int ri, int[] left, int[] right, int[][] dp) {
        if (li >= left.length || ri >= right.length) {
            return 0;
        }

        if (dp[li][ri] != -1) {
            return dp[li][ri];
        }

        dp[li][ri] = 0;

        if (left[li] > right[ri]) {
            dp[li][ri] = Math.max(dp[li][ri], right[ri] + solve(li, ri + 1, left, right, dp));
        }

        dp[li][ri] = Math.max(dp[li][ri], solve(li + 1, ri, left, right, dp));
        dp[li][ri] = Math.max(dp[li][ri], solve(li + 1, ri + 1, left, right, dp));

        return dp[li][ri];
    }

    // 1. Recursive - 모든 경우의 수 탐색
    public static int solution_recur(int[] left, int[] right) {
        return solve_recur(0, 0, left, right);
    }

    private static int solve_recur(int li, int ri, int[] left, int[] right) {
        if (left.length == li || right.length == ri) {
            return 0;
        }

        if (right[ri] < left[li]) {
            int val = solve_recur(li, ri + 1, left, right) + right[ri];
            return val;
        }

        int val = Math.max(solve_recur(li + 1, ri + 1, left, right),
                solve_recur(li + 1, ri, left, right));
        return val;
    }

    // 2. Memoization
    public static int solution_memo(int[] left, int[] right) {
        int[][] memo = new int[left.length][right.length];
        for (int i = 0; i < left.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return solve_memo(0, 0, left, right, memo);
    }

    private static int solve_memo(int li, int ri, int[] left, int[] right, int[][] memo) {
        if (left.length == li || right.length == ri) {
            return 0;
        }

        if (memo[li][ri] != -1) {
            return memo[li][ri];
        }

        if (right[ri] < left[li]) {
            int val = solve_memo(li, ri + 1, left, right, memo) + right[ri];
            memo[li][ri] = val;
            return val;
        }

        int val = Math.max(solve_memo(li + 1, ri + 1, left, right, memo),
                solve_memo(li + 1, ri, left, right, memo));
        memo[li][ri] = val;
        return val;
    }

    // 3. Bottom-up
    public static int solution_btmup(int[] left, int[] right) {
        int[][] dp = new int[left.length + 1][right.length + 1];
        for (int i = left.length - 1; i >= 0; i--) {
            for (int j = right.length - 1; j >= 0; j--) {
                if (left[i] > right[j]) {
                    dp[i][j] = dp[i][j + 1] + right[j];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
                }
            }
        }
        return dp[0][0];
    }
}