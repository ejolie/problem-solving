package com.ejolie.challenge.july;

/**
 * Day7. Island Perimeter
 */
public class Day7 {
    public static void main(String[] args) {
        int[][] grid = {
            {0, 1, 0, 0},
            {1, 1, 1, 0},
            {0, 1, 0, 0},
            {1, 1, 0, 0}
        };
        System.out.println(islandPerimeter(grid));
    }

    public static int islandPerimeter(int[][] grid) {
        int p = 0;
        int N = grid.length, M = grid[0].length;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 0) continue;
                p += 4;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if (grid[nx][ny] == 1) {
                        p--;
                    }
                }
            }
        }
        return p;
    }

    public static int islandPerimeter2(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result += 4;
                    if (i > 0 && grid[i - 1][j] == 1) result -= 2;
                    if (j > 0 && grid[i][j - 1] == 1) result -= 2;
                }
            }
        }
        return result;
    }
}
