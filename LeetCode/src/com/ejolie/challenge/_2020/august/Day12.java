package com.ejolie.challenge._2020.august;

import java.util.LinkedList;
import java.util.List;

/**
 * Day12. Pascal's Triangle II
 */
public class Day12 {
    public static void main(String[] args) {
        int rowIndex = 4;
        List<Integer> result = getRow(rowIndex);
        System.out.println(result.toString());
    }

    public static List<Integer> getRow(int rowIndex) {
        List<int[]> rows = new LinkedList<>();
        rows.add(new int[]{1});
        rows.add(new int[]{1, 1});
        for (int i = 2; i <= rowIndex; i++) {
            int[] row = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) row[j] = 1;
                else row[j] = rows.get(i - 1)[j - 1] + rows.get(i - 1)[j];
            }
            rows.add(row);
        }

        int[] arr = rows.get(rowIndex);
        List<Integer> answer = new LinkedList<>();
        for (int n : arr) {
            answer.add(n);
        }
        return answer;
    }
}
