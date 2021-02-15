package lesson3;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TapeEquilibrium {
    public static void main(String[] args) {
        assertEquals(1, new TapeEquilibrium().solution(new int[]{3, 1, 2, 4, 3}));
    }

    public int solution(int[] A) {
        int N = A.length;
        int right = 0;
        for (int num : A) {
            right += num;
        }

        int minDiff = 2000;
        int left = 0;
        for (int p = 0; p < N - 1; p++) {
            left += A[p];
            right -= A[p];
            int diff = Math.abs(left - right);
            minDiff = Math.min(minDiff, diff);
        }
        return minDiff;
    }
}
