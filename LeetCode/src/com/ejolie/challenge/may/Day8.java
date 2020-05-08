package com.ejolie.challenge.may;

/**
 * Day8. Check If It Is a Straight Line
 */
public class Day8 {
    public static void main(String[] args) {
        int[][] coordinates = {
                {0, 1},
                {1, 3},
                {-4, -7},
                {5, 11}
        };
        System.out.println(checkStraightLine(coordinates));
    }

    public static boolean checkStraightLine(int[][] coord) {
        double G = Math.abs((double) (coord[1][1] - coord[0][1]) / (coord[1][0] - coord[0][0]));
        for (int i = 1; i < coord.length - 1; i++) {
            double g = Math.abs((double) (coord[i + 1][1] - coord[i][1]) / (coord[i + 1][0] - coord[i][0]));
            if (G != g) {
                return false;
            }
        }
        return true;
    }
}
