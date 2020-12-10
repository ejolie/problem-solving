package challenge.summer_winter;

import java.util.Arrays;

public class pg_49994 {

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        String dirs = "ULURRDLLU"; // "ULURRDLLU";
        System.out.println(solution(dirs));
    }

    public static int solution(String dirs) {
        int[][] map = new int[11][11]; // 5,5 중앙
        int x = 5, y = 5;
        int len = 0;

        for (int i = 0; i < dirs.length(); i++) {
            char dir = dirs.charAt(i);
            int nx = x, ny = y;

            if (dir == 'U') {
                nx--;
            } else if (dir == 'D') {
                nx++;
            } else if (dir == 'R') {
                ny++;
            } else {
                ny--;
            }

            if (nx > 10 || nx < 0 || ny > 10 || ny < 0) {
                continue;
            }

            if (map[nx][ny] == 0) {
                map[nx][ny] = 1;
                len++;
            }
            for (int[] m : map) System.out.println(Arrays.toString(m));
            System.out.println();

            x = nx;
            y = ny;
        }
        return len;
    }
}