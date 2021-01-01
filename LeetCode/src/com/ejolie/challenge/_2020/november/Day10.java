package com.ejolie.challenge._2020.november;

import java.util.Arrays;

/**
 * Day10. Flipping an Image
 */
public class Day10 {

    public static void main(String[] args) {
        int[][] A = {
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        };
        int[][] result = flipAndInvertImage(A);
        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static int[][] flipAndInvertImage(int[][] A) {
        int N = A.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][N - 1 - j];
                A[i][N - 1 - j] = temp;
            }
            for (int j = 0; j < N; j++) {
                A[i][j] = A[i][j] ^ 1;
            }
        }
        return A;
    }
}
