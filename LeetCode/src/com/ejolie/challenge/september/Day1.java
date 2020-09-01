package com.ejolie.challenge.september;

/**
 * Day1. Largest Time for Given Digits
 */
public class Day1 {

    private static int maxTime = -1;

    public static void main(String[] args) {
//        int[] A = {1, 2, 3, 4};
        int[] A = {5, 5, 5, 5};
        System.out.println(largestTimeFromDigits(A));
    }

    private static String largestTimeFromDigits(int[] A) {
        maxTime = -1;
        permutation(A, 0);
        if (maxTime == -1) return "";
        return String.format("%02d:%02d", maxTime / 60, maxTime % 60);
    }

    private static void permutation(int[] arr, int depth) {
        if (depth == arr.length) {
            getTime(arr);
            return;
        }

        for (int i = depth; i < arr.length; i++) {
            swap(arr, i, depth);
            permutation(arr, depth + 1);
            swap(arr, i , depth);
        }
    }

    private static void getTime(int[] perm) {
        int hour = perm[0] * 10 + perm[1];
        int minute = perm[2] * 10 + perm[3];
        if (hour < 24 && minute < 60) {
            maxTime = Math.max(maxTime, hour * 60 + minute);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
