package algorithm_practice_kit.sorting;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 가장 큰 수
 */
public class pg_42746 {
    public static void main(String[] args) {
        int[] numbers1 = {6, 10, 2};
        int[] numbers2 = {3, 30, 34, 5, 9};

        assertEquals("6210", solution(numbers1));
        assertEquals("9534330", solution(numbers2));
        assertEquals("40400", solution(new int[]{40, 400}));
        assertEquals("40440", solution(new int[]{40, 404}));
        assertEquals("12121", solution(new int[]{12, 121}));
        assertEquals("3054305", solution(new int[]{3054, 305}));
        assertEquals("3044304", solution(new int[]{3044, 304}));
        assertEquals("3403403", solution(new int[]{340, 3403}));
        assertEquals("3403402", solution(new int[]{340, 3402}));
        assertEquals("3405340", solution(new int[]{340, 3405}));
        assertEquals("40540", solution(new int[]{40, 405}));
        assertEquals("40440", solution(new int[]{40, 404}));
        assertEquals("40403", solution(new int[]{40, 403}));
        assertEquals("40540", solution(new int[]{40, 405}));
        assertEquals("40440", solution(new int[]{40, 404}));
        assertEquals("50403", solution(new int[]{50, 403}));
        assertEquals("50405", solution(new int[]{50, 405}));
        assertEquals("50404", solution(new int[]{50, 404}));
        assertEquals("40330", solution(new int[]{30, 403}));
        assertEquals("40530", solution(new int[]{30, 405}));
        assertEquals("40430", solution(new int[]{30, 404}));
        assertEquals("12121", solution(new int[]{12, 121}));
        assertEquals("223222", solution(new int[]{2, 22, 223}));
        assertEquals("41541", solution(new int[]{41, 415}));
        assertEquals("222", solution(new int[]{2, 22}));
        assertEquals("70000", solution(new int[]{70, 0, 0, 0}));
        assertEquals("1000000", solution(new int[]{0, 0, 0, 1000}));
        assertEquals("0", solution(new int[]{0, 0, 0, 0}));
        assertEquals("7000", solution(new int[]{0, 0, 70}));
        assertEquals("121312", solution(new int[]{12, 1213}));
        assertEquals("91534330", solution(new int[]{3, 30, 34, 5, 91}));
        assertEquals("534330191", solution(new int[]{3, 30, 34, 5, 191}));
        assertEquals("543278934330191", solution(new int[]{3, 30, 34, 5, 191, 432789}));
        assertEquals("5444321", solution(new int[]{1, 2, 3, 4, 5, 44}));
        assertEquals("6654321", solution(new int[]{1, 2, 3, 4, 5, 66}));
        assertEquals("9533130", solution(new int[]{3, 30, 31, 5, 9}));
        assertEquals("953433130", solution(new int[]{3, 30, 31, 34, 5, 9}));
        assertEquals("95343333130", solution(new int[]{3, 30, 31, 34, 33, 5, 9}));
        assertEquals("10110", solution(new int[]{10, 101}));
        assertEquals("1111111111", solution(new int[]{1, 11, 111, 1111}));
        assertEquals("0", solution(new int[]{0, 0, 0, 0, 0, 0}));
    }

    // numbers.length: 1 ~ 10^5
    public static String solution(int[] numbers) {
        int N = numbers.length;
        String[] strNumbers = new String[N];
        for (int i = 0; i < N; i++) {
            strNumbers[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(strNumbers, (a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            String ab = a + b;
            String ba = b + a;
            return ab.compareTo(ba);
        });

        StringBuilder sb = new StringBuilder(strNumbers[N - 1]);
        for (int i = N - 2; i >= 0; i--) {
            if (sb.charAt(0) == '0' && "0".equals(strNumbers[i])) {
                continue;
            }
            sb.append(strNumbers[i]);
        }

        return sb.toString();
    }
}
