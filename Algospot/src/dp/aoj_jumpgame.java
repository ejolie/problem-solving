package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 외발 뛰기 (난이도: 하)
 */
public class aoj_jumpgame {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n = 0;
    static int[][] memo;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        int cases = Integer.parseInt(br.readLine().trim());

        while (cases-- > 0) {
            n = Integer.parseInt(br.readLine().trim());

            StringTokenizer st;
            board = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            memo = new int[n][n];
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }

            int answer = jump_dp(0, 0);
            System.out.println(answer == 1 ? "YES" : "NO");
        }
    }

    public static int jump_dp(int r, int c) {
        // base case: 게임판 범위를 벗어나는 경우
        if (r >= n || c >= n) {
            return 0;
        }

        // base case: 끝 점에 도달하는 경우
        if (r == n - 1 && c == n - 1) {
            return 1;
        }

        // memoization
        if (memo[r][c] != -1) {
            return memo[r][c];
        }

        int jumpSize = board[r][c];
        memo[r][c] = Math.max(jump_dp(r, c + jumpSize), jump_dp(r + jumpSize, c));
        return memo[r][c];
    }

    public static boolean jump_bruteForce(int r, int c) {
        if (r >= n || c >= n) {
            return false;
        }

        if (r == n - 1 && c == n - 1) {
            return true;
        }

        int jumpSize = board[r][c];
        return jump_bruteForce(r, c + jumpSize) || jump_bruteForce(r + jumpSize, c);
    }
}
