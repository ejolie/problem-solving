package algorithm_practice_kit.greedy;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 큰 수 만들기
 */
public class pg_42883 {
    public static void main(String[] args) {
        assertEquals("94", solution("1924", 2));
        assertEquals("3234", solution("1231234", 3));
        assertEquals("775841", solution("4177252841", 4));
    }

    // 큰 수 N자리 = 제일 큰 수 1개 + 나머지 숫자 N-1자리
    public static String solution(String number, int k) {
        int N = number.length();
        int M = N - k;

        StringBuilder result = new StringBuilder();
        int startIndex = 0;
        while (M > 0) {
            int maxIndex = startIndex;
            int endIndex = N - M;
            for (int i = startIndex; i <= endIndex; i++) {
                if (number.charAt(i) == '9') {
                    maxIndex = i;
                    break;
                }
                if (number.charAt(i) > number.charAt(maxIndex)) {
                    maxIndex = i;
                }
            }

            result.append(number.charAt(maxIndex));
            startIndex = maxIndex + 1;
            M--;
        }

        return result.toString();
    }
}
