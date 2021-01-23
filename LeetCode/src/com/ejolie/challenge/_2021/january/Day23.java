package com.ejolie.challenge._2021.january;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Day23. Sort the Matrix Diagonally
 */
public class Day23 {
    public static void main(String[] args) {
        int[][] mat = {
                {3, 3, 1, 1},
                {2, 2, 1, 2},
                {1, 1, 1, 2}
        };
        int[][] expected = {
                {1, 1, 1, 1},
                {1, 2, 2, 2},
                {1, 2, 3, 3}
        };
        assertEquals(expected, diagonalSort(mat));
    }

    public static int[][] diagonalSort(int[][] mat) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        int R = mat.length;
        int C = mat[0].length;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map.putIfAbsent(i - j, new LinkedList<>());
                map.get(i - j).add(mat[i][j]);
            }
        }

        for (Integer diff : map.keySet()) {
            Collections.sort(map.get(diff));
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                mat[i][j] = map.get(i - j).remove(0);
            }
        }

        return mat;
    }

    public static int[][] diagonalSort_priorityQueue(int[][] mat) {
        HashMap<Integer, PriorityQueue<Integer>> h = new HashMap<>();

        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                h.putIfAbsent(i - j, new PriorityQueue<>());
                h.get(i - j).add(mat[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = h.get(i - j).poll();
            }
        }

        return mat;
    }
}
