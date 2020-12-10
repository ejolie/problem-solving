package algorithm_practice_kit.hash;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 위장
 * - point: 경우의 수(조합) 구하기
 * 1. 옷 종류별로 옷 1개를 선택하거나 안 입는 경우를 구한다.
 * = 옷 종류에 속한 옷 갯수 + 1(안 입는 경우)
 * <p>
 * 2. 옷 종류별 조합을 곱한다. (종류별로 고르는 것은 서로 영향을 미치지 않으므로)
 * = (가1 + 가2 + X) * (나1 + X) * (다1 + X)
 * = (가 종류 옷 갯수 + 1) * (나 종류 옷 갯수 + 1) * (다 종류 옷 갯수 + 1)
 * <p>
 * 3. 모두 안 입는 경우를 빼준다. -> -1
 */
public class pg_42578 {
    public static void main(String[] args) {
        String[][] clothes1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}};
        String[][] clothes2 =
                {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

        assertEquals(5, solution(clothes1));
        assertEquals(3, solution(clothes2));
    }

    public static int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] item : clothes) {
            int count = map.getOrDefault(item[1], 0);
            map.put(item[1], count + 1);
        }

        int totalComb = 1;
        for (int count : map.values()) {
            totalComb *= (count + 1);
        }

        return totalComb - 1;
    }
}
