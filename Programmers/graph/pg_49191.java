package graph;

/**
 * 순위
 */
public class pg_49191 {
    public static void main(String[] args) {
        int n = 5;
        int[][] results = {
            {4, 3},
            {4, 2},
            {3, 2},
            {1, 2},
            {2, 5}
        };

        System.out.println(solution(n, results));
    }

    public static int solution(int n, int[][] results) {
        int INF = 987654321;
        int[][] dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        for (int[] result : results) {
            int a = result[0], b = result[1];
            dist[a][b] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                if (dist[i][j] != INF || dist[j][i] != INF) {
                    cnt++;
                }
            }
            if (cnt == n - 1) ans++;
        }

        return ans;
    }
}