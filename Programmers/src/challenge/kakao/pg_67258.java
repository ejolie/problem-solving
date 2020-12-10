package challenge.kakao;

import java.util.*;

/**
 * 2020 카카오 인턴십 - 보석 쇼핑
 */
public class pg_67258 {
    public static void main(String[] args) {
        String[] gems1 = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(Arrays.toString(solution(gems1)));

        String[] gems2 = {"AA", "AB", "AC", "AA", "AC"};
        System.out.println(Arrays.toString(solution(gems2)));

        String[] gems3 = {"XYZ", "XYZ", "XYZ"};
        System.out.println(Arrays.toString(solution(gems3)));

        String[] gems4 = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        System.out.println(Arrays.toString(solution(gems4)));
    }

    /**
     * - 진열된 모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간을 찾아서 구매 - 구간 여러 개인 경우, 시작 진열대 번호가 더 작은 것이 답
     */
    public static int[] solution(String[] gems) {
        Map<String, Integer> map = new HashMap<>();
        for (String gem : gems) {
            int count = map.getOrDefault(gem, 0);
            map.put(gem, count + 1);
        }

        int total = map.keySet().size();
        int[] result = search(0, 0, total, gems, map);
        return result;
    }

    private static int[] search(int start, int end, int total, String[] gems,
                                Map<String, Integer> map) {
        int N = gems.length;
        int minStart = N - 1;
        int minEnd = N - 1;
        while (start >= 0 && start < N && end >= 0 && end < N) {
            int count = 0;
            for (int i = start; i <= end; i++) {
                count += map.get(gems[i]);
            }
            if (count == total) {
                map.put(gems[start], map.get(gems[start]) - 1);
                if (map.get(gems[start]) == 0) {
                    map.remove(gems[start]);
                }
                int[] result = search(start + 1, end, total, gems, map);
                if (result[0] < minStart) {
                    minStart = result[0];
                    minEnd = result[1];
                }
            } else if (count < total) {
                end++;
                if (end < N) {
                    map.put(gems[end], map.get(gems[end]) + 1);
                }
            }
        }
        return new int[]{minStart, minEnd};
    }
}
