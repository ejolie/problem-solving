package algorithm_practice_kit.dp;

/**
 * N으로 표현
 */
public class pg_42895 {
    public static void main(String[] args) {
        int N = 2;
        int number = 11;
        System.out.println(solution(N, number));
    }

    // 1. DFS
    public static int solution(int N, int number) {
        int[] answer = {9};
        dfs(N, number, 0, 0, answer);
        return answer[0] > 8 ? -1 : answer[0];
    }

    public static void dfs(int N, int number, int cnt, int val, int[] answer) {
        if (cnt > 8) {
            return;
        }

        if (val == number) {
            answer[0] = Math.min(answer[0], cnt);
            return;
        }

        int num = 0;
        for (int i = 1; i <= 8; i++) {
            num = num * 10 + N;
            dfs(N, number, cnt + i, val + num, answer);
            dfs(N, number, cnt + i, val - num, answer);
            dfs(N, number, cnt + i, val * num, answer);
            dfs(N, number, cnt + i, val / num, answer);
        }
    }
}