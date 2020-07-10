package challenge.kakao;

import java.util.*;

/**
 * 2020 카카오 인턴십 - 키패드 누르기
 */
public class pg_67256 {
    public static void main(String[] args) {
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        System.out.println(solution(numbers, hand));
    }

    public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        Point left = new Point(3, 0);
        Point right = new Point(3, 2);
        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                sb.append("L");
                left.x = num / 3;
                left.y = 0;
            } else if (num == 3 || num == 6 || num == 9) {
                sb.append("R");
                right.x = num / 3 - 1;
                right.y = 2;
            } else {
                Point p = new Point(num / 3, 1, 0);
                if (num == 0) p.x = 3;
                int leftD = getDistance(p, left, 987654321);
                int rightD = getDistance(p, right, leftD);

                if (leftD < rightD) {
                    sb.append("L");
                    left.x = p.x;
                    left.y = p.y;
                } else if (leftD > rightD) {
                    sb.append("R");
                    right.x = p.x;
                    right.y = p.y;
                } else {
                    if ("left".equals(hand)) {
                        sb.append("L");
                        left.x = p.x;
                        left.y = p.y;
                    } else {
                        sb.append("R");
                        right.x = p.x;
                        right.y = p.y;
                    }
                }
            }
        }

        return sb.toString();
    }

    private static int getDistance(Point start, Point end, int prevD) {
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        boolean[][] visited = new boolean[4][3];
        int dist = 0;

        Queue<Point> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            Point p = q.poll();
            if ((p.x == end.x && p.y == end.y) || p.d > prevD) {
                dist = p.d;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dir[i][0];
                int ny = p.y + dir[i][1];
                if (nx < 0 || nx > 3 || ny < 0 || ny > 2) continue;
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny, p.d + 1));
                }
            }
        }

        return dist;
    }

    static class Point {
        int x;
        int y;
        int d;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int d) {
            this(x, y);
            this.d = d;
        }
    }
}
