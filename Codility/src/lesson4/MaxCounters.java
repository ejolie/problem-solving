package lesson4;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MaxCounters {
    public static void main(String[] args) {
        assertArrayEquals(new int[]{3, 2, 2, 4, 2}, new MaxCounters().solution(5, new int[]{3, 4, 4, 6, 1, 4, 4}));
    }

    public int[] solution_timeOver(int N, int[] A) {
        int[] counter = new int[N];
        int maxValue = 0;
        for (int pos : A) {
            if (pos == N + 1) {
                Arrays.fill(counter, maxValue);
            } else {
                counter[pos - 1]++;
                maxValue = Math.max(maxValue, counter[pos - 1]);
            }
        }
        return counter;
    }

    public int[] solution(int N, int[] A) {
        int[] counter = new int[N];
        int maxValue = 0;
        int maxCounterValue = 0;
        for (int pos : A) {
            if (pos == N + 1) {
                maxCounterValue = maxValue;
            } else {
                counter[pos - 1] = Math.max(counter[pos - 1], maxCounterValue);
                counter[pos - 1]++;
                maxValue = Math.max(maxValue, counter[pos - 1]);
            }
        }

        for (int i = 0; i < N; i++) {
            counter[i] = Math.max(counter[i], maxCounterValue);
        }
        return counter;
    }
}
