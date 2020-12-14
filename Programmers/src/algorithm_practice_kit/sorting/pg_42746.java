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
        assertEquals("40540", solution(new int[]{40, 405}));
        assertEquals("40403", solution(new int[]{40, 403}));
        assertEquals("41541", solution(new int[]{41, 415}));
        assertEquals("12121", solution(new int[]{12, 121}));
        assertEquals("3054305", solution(new int[]{3054, 305}));
        assertEquals("223222", solution(new int[]{2, 22, 223}));
        assertEquals("222", solution(new int[]{2, 22}));
        assertEquals("70000", solution(new int[]{70, 0, 0, 0}));
        assertEquals("1000000", solution(new int[]{0, 0, 0, 1000}));
        assertEquals("0", solution(new int[]{0, 0, 0, 0}));
        assertEquals("91534330", solution(new int[]{3, 30, 34, 5, 91}));
        assertEquals("534330191", solution(new int[]{3, 30, 34, 5, 191}));
        assertEquals("543278934330191", solution(new int[]{3, 30, 34, 5, 191, 432789}));
        assertEquals("5444321", solution(new int[]{1, 2, 3, 4, 5, 44}));
        assertEquals("95343333130", solution(new int[]{3, 30, 31, 34, 33, 5, 9}));
        assertEquals("10110", solution(new int[]{10, 101}));
        assertEquals("1111111111", solution(new int[]{1, 11, 111, 1111}));
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
                return b.compareTo(a);
            }
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);
        });

        if ("0".equals(strNumbers[0])) {
            return "0";
        }

        return String.join("", strNumbers);
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < N; i++) {
//            sb.append(strNumbers[i]);
//        }
//        return sb.toString();
    }
}
