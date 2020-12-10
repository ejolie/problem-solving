package exercise;

public class pg_12952 {
    private static int ans = 0;

    public static void main(String[] args) {
        int n = 4;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int[][] board = new int[n][n];
        solve(board, 0, n);
        return ans;
    }

    private static void solve(int[][] board, int col, int N) {
        if (col == N) {
            ans++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isPromising(board, i, col, N)) {
                board[i][col] = 1;
                solve(board, col + 1, N);
                board[i][col] = 0;
            }
        }
    }

    private static boolean isPromising(int[][] board, int row, int col, int N) {
        int i, j;

        // row 체크
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // 오른쪽 위 대각선 체크
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // 왼쪽 위 대각선 체크
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }
}