package algorithm_practice_kit.greedy;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 체육복
 */
public class pg_42862 {
    public static void main(String[] args) {
        assertEquals(5, solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
        assertEquals(4, solution(5, new int[]{2, 4}, new int[]{3}));
        assertEquals(2, solution(3, new int[]{3}, new int[]{1}));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n + 1];

        for (int student : lost) {
            students[student] = -1;
        }
        for (int student : reserve) {
            students[student]++;
        }

        for (int i = 1; i <= n; i++) {
            if (students[i] < 1) {
                continue;
            }

            if (students[i - 1] == -1) {
                students[i - 1]++;
                students[i]--;
            } else if (i + 1 <= n && students[i + 1] == -1) {
                students[i + 1]++;
                students[i]--;
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (students[i] > -1) {
                count++;
            }
        }

        return count;
    }
}
