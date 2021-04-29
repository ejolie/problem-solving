package com.ejolie.problems.medium._48;

import java.util.Arrays;

/**
 * 48. Rotate Image
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix1 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        solution.rotate(matrix1);
        for (int[] m : matrix1) {
            System.out.println(Arrays.toString(m));
        }
    }

    // clockwise 90' rotated = transposed + reversed
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        transpose(matrix, N);
        reverseVertically(matrix, N);
    }

    private void transpose(int[][] matrix, int N) {
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    private void reverseVertically(int[][] matrix, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                swap(matrix, i, j, i, N - 1 - j);
            }
        }
    }

    private void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }
}
