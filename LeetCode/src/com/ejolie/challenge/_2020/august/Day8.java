package com.ejolie.challenge._2020.august;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Day8. Rotting Oranges
 */
public class Day8 {
    private static final int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(orangesRotting(grid));
    }

    private static int orangesRotting(int[][] grid) {
        int time = 0;
        int N = grid.length;

        while (true) {
            boolean[][] visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] == 2) {
                        rotten(grid, i, j, visited);
                    }
                }
            }
            time++;
            break;
        }

        return time;
    }

    private static void rotten(int[][] grid, int x, int y, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int cx = cell[0], cy = cell[1];
            visited[cx][cy] = true;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dir[i][0];
                int ny = cy + dir[i][1];
                if (nx < 0 || nx > grid.length || ny < 0 || ny > grid.length) continue;
                if (!visited[nx][ny] && grid[nx][ny] == 1) {
                    //
                }
            }
        }
    }
}
