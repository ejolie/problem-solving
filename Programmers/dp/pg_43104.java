package dp;

/**
 * 타일 장식물
 */
public class pg_43104 {
    public static void main(String[] args) {
        int N = 5;
        System.out.println(solution(N));
    }
    
    public static long solution(int N) {
        long[] dp = new long[81];
        dp[1] = dp[2] = 1L;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return (4 * dp[N]) + (2 * dp[N - 1]);
    }
}