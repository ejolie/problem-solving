package challenge.monthly_code.season2;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        // int[][] arr1 = {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}};
        // System.out.println(Arrays.toString(solution(arr1)));

        int[][] arr2 = {{1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1}, {0, 1, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 1, 1, 1, 1}};
        System.out.println(Arrays.toString(solution(arr2)));
    }

    public static int[] solution(int[][] arr) {
        Map<Integer, Integer> result = new HashMap<>();
        reduce(result, arr, 0, 0, arr.length, arr.length);

        return new int[]{result.get(0), result.get(1)};
    }

    private static int reduce(Map<Integer, Integer> result, int[][] arr, int sr, int sc, int er,
                              int ec) {
        int N = er - sr;
        int first = arr[sr][sc];
        if (N == 1) {
            int cnt = result.getOrDefault(first, 0);
            result.put(first, cnt + 1);
            return first;
        } else {
            int lu = reduce(result, arr, sr, sc, sr + N / 2, sc + N / 2);
            int ru = reduce(result, arr, sr, sc + N / 2, sr + N / 2, sc + N);
            int ld = reduce(result, arr, sr + N / 2, sc, sr + N, sc + N / 2);
            int rd = reduce(result, arr, sr + N / 2, sc + N / 2, sr + N, sc + N);
            if (lu == ru && ru == ld && ld == rd && rd != -1) {
                int cnt = result.get(lu);
                result.put(lu, cnt - 3);
                return lu;
            } else {
                return -1;
            }
        }
    }
}
