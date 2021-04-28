package com.ejolie.problems.medium._62;

import static org.junit.Assert.assertEquals;

/**
 * 62. Unique Paths
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        assertEquals(28, solution.uniquePaths(3, 7));
        assertEquals(3, solution.uniquePaths(3, 2));
        assertEquals(28, solution.uniquePaths(7, 3));
        assertEquals(6, solution.uniquePaths(3, 3));
    }

    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        for (int r = 0; r < m; r++) {
            paths[r][0] = 1;
        }

        for (int c = 0; c < n; c++) {
            paths[0][c] = 1;
        }

        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                paths[r][c] = paths[r - 1][c] + paths[r][c - 1];
            }
        }
        return paths[m - 1][n - 1];
    }
}
