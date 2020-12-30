package exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 멀리 뛰기
 */
public class pg_12914 {
    static final int MOD = 1234567;

    public static void main(String[] args) {
        assertEquals(1, solution(1));
        assertEquals(5, solution(4));
        assertEquals(3, solution(3));
    }

    public static long solution(int n) {
        if (n < 3) {
            return n;
        }

        long[] jumps = new long[n + 1];
        jumps[1] = 1;
        jumps[2] = 2;

        for (int i = 3; i <= n; i++) {
            jumps[i] = (jumps[i - 1] + jumps[i - 2]) % MOD;
        }

        return jumps[n];
    }

    public static long solution_old(int n) {
        long[] arr = new long[3];
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= n; i++) {
            int a = (i - 2) % 3;
            int b = (i - 1) % 3;
            int c = i % 3;
            arr[c] = (arr[a] + arr[b]) % 1234567;
        }

        return arr[n % 3];
    }
}
