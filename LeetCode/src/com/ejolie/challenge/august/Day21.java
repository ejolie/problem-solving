package com.ejolie.challenge.august;

import java.util.Arrays;

/**
 * Day21. Sort Array By Parity
 */
public class Day21 {
    public static void main(String[] args) {
        int[] A = {3, 1, 4, 2};
        int[] result = sortArrayByParity(A);
        System.out.println(Arrays.toString(result));
    }

    public static int[] sortArrayByParity(int[] A) {
        int[] result = new int[A.length];
        int idx = 0;
        for (int value : A) {
            if (value % 2 == 0) {
                result[idx++] = value;
            }
        }
        for (int value : A) {
            if (value % 2 == 1) {
                result[idx++] = value;
            }
        }
        return result;
    }

    // 2. In-place swap
    public static int[] sortArrayByParity2(int[] A) {
        for (int i = 0, j = 0; j < A.length; j++) {
            if (A[j] % 2 == 0) {
                int temp = A[i];
                A[i++] = A[j];
                A[j] = temp;
            }
        }
        return A;
    }

    // 3. 2 pointer
    public static int[] sortArrayByParity3(int[] A) {
        int start = 0;
        int end = A.length - 1;
        int[] result = new int[A.length];
        for (int value : A) {
            if (value % 2 == 0) {
                result[start++] = value;
            } else {
                result[end--] = value;
            }
        }
        return result;
    }
}
