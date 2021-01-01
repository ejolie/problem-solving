package com.ejolie.challenge._2020.july;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Day3. Prison Cells After N Days
 */
public class Day3 {
    public static void main(String[] args) {
        int[] cells = {1, 0, 0, 1, 0, 0, 1, 0};
        int N = 1000000000;

//        int[] cells = {0,1,0,1,1,0,0,1};
//        int N = 7;

        System.out.println(Arrays.toString(prisonAfterNDays(cells, N)));
    }

    // 1. Find Cycle: 2^6
    public static int[] prisonAfterNDays(int[] cells, int N) {
        if (cells == null || cells.length == 0 || N <= 0) return cells;

        boolean hasCycle = false;
        int cycle = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int[] next = getNextDayCells(cells);
            String key = Arrays.toString(next);

            if (set.contains(key)) {
                hasCycle = true;
                break;
            }

            set.add(key);
            cycle++;
            cells = next;
        }

        if (hasCycle) {
            N = N % cycle;
            for (int i = 0; i < N; i++) {
                cells = getNextDayCells(cells);
            }
        }

        return cells;
    }

    private static int[] getNextDayCells(int[] cells) {
        int[] next = new int[cells.length];
        for (int i = 1; i < cells.length - 1; i++) {
            next[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        }
        return next;
    }

    // 2. Cycle: 1, 7, 14 days
    public static int[] prisonAfterNDays2(int[] cells, int N) {
        N = (N - 1) % 14 + 1;
        for (int i = 0; i < N; i++) {
            cells = getNextDayCells(cells);
        }
        return cells;
    }
}
