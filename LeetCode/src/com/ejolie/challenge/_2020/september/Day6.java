package com.ejolie.challenge._2020.september;

/**
 * Day6. Image Overlap
 */
public class Day6 {
    public static void main(String[] args) {
        int[][] A = {
                {1, 1, 0},
                {0, 1, 0},
                {0, 1, 0}
        };
        int[][] B = {
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 1}
        };
        System.out.println(largestOverlap(A, B));
    }

    public static int largestOverlap(int[][] A, int[][] B) {
        int answer = 0;
        int N = A.length;
        int[][] dirs = {{-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

        for (int[] dir : dirs) {
            for (int xMove = 0; xMove < N; xMove++) {
                for (int yMove = 0; yMove < N; yMove++) {
                    int count = 0;
                    for (int x = 0; x < N; x++) {
                        for (int y = 0; y < N; y++) {
                            if (A[x][y] != 1) continue;
                            int nx = x + dir[0] * xMove;
                            int ny = y + dir[1] * yMove;
                            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                            if (B[nx][ny] == 1) count++;
                        }
                    }
                    answer = Math.max(answer, count);
                }
            }
        }

        return answer;
    }
}
