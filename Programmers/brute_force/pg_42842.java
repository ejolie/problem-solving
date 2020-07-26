package brute_force;

import java.util.Arrays;

/**
 * 카펫
 */
public class pg_42842 {
    public static void main(String[] args) {
        int brown = 8;
        int yellow = 1;
        int[] result = solution(brown, yellow);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int brown, int yellow) {
        int w = 1, h = 1;
        int area = brown + yellow;

        for (; h * h <= area; h++) {
            w = area / h;
            if (h <= w && (h - 2) * (w - 2) == yellow) {
                break;
            }
        }

        return new int[]{w, h};
    }
}
