package com.ejolie.challenge.november;

import java.util.Arrays;

/**
 * Day11. Valid Square
 */
public class Day11 {
    public static void main(String[] args) {
        int[] p1 = {0, 0};
        int[] p2 = {1, 1};
        int[] p3 = {1, 0};
        int[] p4 = {0, 1};
        System.out.println(validSquare(p1, p2, p3, p4));
    }

    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        boolean result = false;
        double[] dist = new double[6];

        dist[0] = getDistance(p1, p2);
        dist[1] = getDistance(p1, p3);
        dist[2] = getDistance(p1, p4);
        dist[3] = getDistance(p2, p3);
        dist[4] = getDistance(p2, p4);
        dist[5] = getDistance(p3, p4);
        Arrays.sort(dist);

        if ((dist[0] > 0 && dist[0] == dist[1] && dist[1] == dist[2] && dist[2] == dist[3])
                && (dist[4] == dist[5])) {
            result = true;
        }

        return result;
    }

    private static double getDistance(int[] x, int[] y) {
        return Math.sqrt(Math.pow(y[0] - x[0], 2) + Math.pow(y[1] - x[1], 2));
    }
}