package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 삼각형 위의 최대 경로 (난이도: 하)
 */
public class aoj_trianglepath {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n = 0;
    static int[][] map;
    static int[][] memo;

    public static void main(String[] args) throws IOException {
        int cases = Integer.parseInt(br.readLine().trim());

        while (cases-- > 0) {
            n = Integer.parseInt(br.readLine().trim());

            StringTokenizer st;
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j <= i; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            memo = new int[n][n];
            for (int[] m : memo) {
                Arrays.fill(m, -1);
            }

            int answer = path(0, 0);
            System.out.println(answer);
        }
    }

    /**
     * (r, c) 위치부터 끝 점까지 내려가면서 얻을 수 있는 최대 경로의 합을 반환한다.
     */
    public static int path(int r, int c) {
        // base case: 끝 점에 도달했을 때
        if (r == n - 1) {
            return map[r][c];
        }

        // memoization
        if (memo[r][c] != -1) {
            return memo[r][c];
        }

        memo[r][c] = Math.max(path(r + 1, c), path(r + 1, c + 1)) + map[r][c];
        return memo[r][c];
    }
}
