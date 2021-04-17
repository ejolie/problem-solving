package challenge.monthly_code._2020.season1;

import java.util.Arrays;

/**
 * 월간 코드 챌린지 시즌1(9월) - Q2
 */
public class Q2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4)));
        System.out.println(Arrays.toString(solution(5)));
        System.out.println(Arrays.toString(solution(6)));
    }

    public static int[] solution(int n) {
        int[][] map = new int[n][n];
        int N = (1 + n) * n / 2;

        char dir = 'D';
        int cx = 0;
        int cy = 0;
        int num = 1;
        while (num <= N) {
            if (dir == 'D') {
                while (cx >= 0 && cx < n && cy >= 0 && cy < n && map[cx][cy] == 0) {
                    map[cx++][cy] = num++;
                }
                dir = 'R';
                cx--;
                cy++;
            } else if (dir == 'R') {
                while (cx >= 0 && cx < n && cy >= 0 && cy < n && map[cx][cy] == 0) {
                    map[cx][cy++] = num++;
                }
                dir = 'U';
                cy -= 2;
                cx--;
            } else if (dir == 'U') {
                while (cx >= 0 && cx < n && cy >= 0 && cy < n && map[cx][cy] == 0) {
                    map[cx--][cy--] = num++;
                }
                dir = 'D';
                cy++;
                cx += 2;
            }
        }

        int[] answer = new int[N];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0)
                    continue;
                answer[idx++] = map[i][j];
            }
        }
        return answer;
    }
}
