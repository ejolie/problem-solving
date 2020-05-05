package com.ejolie.problems.medium._807;

/*
 * 807. Max Increase to Keep City Skyline
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        System.out.println(solution.maxIncreaseKeepingSkyline(grid));
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int cnt = 0, N = grid.length;
        int[][] maxArr = new int[2][N];
//        int[] rowMax = new int[N];
//        int[] colMax = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maxArr[0][i] = Math.max(maxArr[0][i], grid[i][j]);
                maxArr[1][j] = Math.max(maxArr[1][j], grid[i][j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cnt += Math.min(maxArr[0][i], maxArr[1][j]) - grid[i][j];
            }
        }
        return cnt;
    }
}
