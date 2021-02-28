package lesson5;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinAvgTwoSlice {
    public static void main(String[] args) {
        assertEquals(1, new MinAvgTwoSlice().solution(new int[]{4, 2, 2, 5, 1, 5, 8}));
    }

    // 60%
    public int solution(int[] A) {
        int N = A.length;
        int[][] sum = new int[N][N];
        for (int i = 0; i < N; i++) {
            sum[i][i] = A[i];
        }

        double minSum = 1000000000;
        int minStart = 0;
        int minEnd = 1;
        for (int s = 0; s < N; s++) {
            for (int e = s + 1; e < N; e++) {
                sum[s][e] = sum[s][e - 1] + A[e];
                if ((double) sum[s][e] / (e - s + 1) < minSum / (minEnd - minStart + 1)) {
                    minSum = sum[s][e];
                    minStart = s;
                    minEnd = e;
                }
            }
        }
        return minStart;
    }

    // 100%
    public int solution_math(int[] A) {
        double minAvg = (A[0] + A[1]) / 2.0;
        int minStart = 0;
        for (int i = 2; i < A.length; i++) {
            double avg = (A[i - 2] + A[i - 1] + A[i]) / 3.0;
            if (avg < minAvg) {
                minAvg = avg;
                minStart = i - 2;
            }

            avg = (A[i - 1] + A[i]) / 2.0;
            if (avg < minAvg) {
                minAvg = avg;
                minStart = i - 1;
            }
        }
        return minStart;
    }
}
