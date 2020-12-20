package algorithm_practice_kit.brute_force;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 카펫
 */
public class pg_42842 {
    public static void main(String[] args) {
        assertArrayEquals(new int[]{4, 3}, solution(10, 2));
        assertArrayEquals(new int[]{3, 3}, solution(8, 1));
        assertArrayEquals(new int[]{8, 6}, solution(24, 24));
    }

    public static int[] solution(int brown, int yellow) {
        int area = brown + yellow;
        int w = 3;
        int h = 3;

        for (; h * h <= area; h++) {
            w = area / h;
            if (h <= w && (h - 2) * (w - 2) == yellow) {
                break;
            }
        }

        return new int[]{w, h};
    }

}
