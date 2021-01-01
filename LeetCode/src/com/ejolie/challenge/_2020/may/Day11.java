package com.ejolie.challenge._2020.may;

import java.util.*;

/**
 * Day11. Flood Fill
 */
public class Day11 {
    private static final int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        int[][] image = {
                {0, 0, 0},
                {0, 0, 0}
        };
        int sr = 0;
        int sc = 0;
        int newColor = 2;

        int[][] result = floodFill(image, sr, sc, newColor);
        for (int[] res : result) {
            System.out.println(Arrays.toString(res));
        }
    }

    // 1. DFS
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private static void dfs1(int[][] image, int cx, int cy, int startColor, int newColor) {
        if (cx < 0 || cx >= image.length || cy < 0 || cy >= image[0].length || image[cx][cy] != startColor) return;
        image[cx][cy] = newColor;
        dfs(image, cx - 1, cy, startColor, newColor);
        dfs(image, cx, cy + 1, startColor, newColor);
        dfs(image, cx + 1, cy, startColor, newColor);
        dfs(image, cx, cy - 1, startColor, newColor);
    }

    // 2. DFS
    private static void dfs(int[][] image, int cx, int cy, int startColor, int newColor) {
        if (cx < 0 || cx >= image.length || cy < 0 || cy >= image[0].length || image[cx][cy] != startColor) return;
        image[cx][cy] = newColor;
        for (int[] dir : dirs) {
            int nx = cx + dir[0];
            int ny = cy + dir[1];
            dfs(image, nx, ny, startColor, newColor);
        }
    }

    // 3. BFS
    public int[][] bfs(int[][] image, int sr, int sc, int newColor) {
        int startColor = image[sr][sc];
        if (startColor == newColor) return image;

        int N = image.length;
        int M = image[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        q.add(new int[]{sr, sc});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            image[curr[0]][curr[1]] = newColor;

            for (int[] dir : dirs) {
                int nx = curr[0] + dir[0];
                int ny = curr[1] + dir[1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M
                        || image[nx][ny] != startColor || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }

        return image;
    }
}
