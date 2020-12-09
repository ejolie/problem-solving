package sorting;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * H-Index
 */
public class pg_42747 {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};

        assertEquals(3, solution(citations));
        assertEquals(5, solution(new int[]{12, 11, 10, 9, 8, 1}));
        assertEquals(5, solution(new int[]{6, 6, 6, 6, 6, 1}));
        assertEquals(3, solution(new int[]{4, 4, 4}));
        assertEquals(1, solution(new int[]{0, 0, 1, 1}));
        assertEquals(1, solution(new int[]{0, 1}));
        assertEquals(0, solution(new int[]{0, 0}));
    }

    // h이상 숫자 >= h개, h미만 숫자: 나머지 -> h의 최댓값: h-index
    // 1. 오름차순 정렬 후, 뒤에서부터 보면서 h-index 찾으면 그게 바로 최댓값
    // 2. [주의] 배열에 있는 값 중 찾는 것이 아님
    public static int solution(int[] citations) {
        int N = citations.length;
        int hIndex = 0;
        Arrays.sort(citations);

        for (int i = N - 1; i >= 0; i--) {
            if (citations[i] <= hIndex) {
                break;
            }
            hIndex++;
        }

        return hIndex;
    }
}
