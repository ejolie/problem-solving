package exercise;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 피보나치 수
 */
public class pg_12945 {
    static final int MOD = 1234567;

    public static void main(String[] args) {
        assertEquals(2, solution_bottomUp(3));
        assertEquals(5, solution_bottomUp(5));
        assertEquals(2, solution_topDownHelper(3));
        assertEquals(5, solution_topDownHelper(5));
    }

    public static int solution_bottomUp(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i] = (memo[i - 1] + memo[i - 2]) % MOD;
        }

        return memo[n];
    }

    public static int solution_topDown(int n, int[] memo) {
        if (memo[n] != -1) {
            return memo[n];
        }

        if (n < 2) {
            memo[n] = n;
        } else {
            memo[n] = (solution_topDown(n - 1, memo) + solution_topDown(n - 2, memo)) % MOD;
        }

        return memo[n];
    }

    public static int solution_topDownHelper(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return solution_topDown(n, memo);
    }
}
