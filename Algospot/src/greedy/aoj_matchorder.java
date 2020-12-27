package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * 출전 순서 정하기 (난이도: 하)
 */
public class aoj_matchorder {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] rusRatings;
    static int[] korRatings;

    public static void main(String[] args) throws IOException {
        int C = Integer.parseInt(br.readLine().trim());

        while (C-- > 0) {
            N = Integer.parseInt(br.readLine().trim());
            rusRatings = new int[N];
            korRatings = new int[N];

            StringTokenizer st;
            st = new StringTokenizer(br.readLine().trim(), " ");
            for (int i = 0; i < N; i++) {
                rusRatings[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine().trim(), " ");
            for (int i = 0; i < N; i++) {
                korRatings[i] = Integer.parseInt(st.nextToken());
            }

            int answer = plan();
//            int answer = plan_bst();
            System.out.println(answer);
        }
    }

    public static int plan() {
        Arrays.sort(rusRatings);
        Arrays.sort(korRatings);

        int wins = 0;
        int korOrder = 0, rusOrder = 0;
        while (korOrder < N) {
            if (korRatings[korOrder] >= rusRatings[rusOrder]) {
                wins++;
                rusOrder++;
            }
            korOrder++;
        }

        return wins;
    }

    public static int plan_bst() {
        TreeMap<Integer, Integer> koreans = new TreeMap<>();
        for (int rating : korRatings) {
            int count = koreans.getOrDefault(rating, 0);
            koreans.put(rating, count + 1);
        }

        int wins = 0;
        for (int i = 0; i < N; i++) {
            if (koreans.lastKey() < rusRatings[i]) {
                // Case 1. 가장 레이팅이 높은 한국 선수가 러시아 선수를 이길 수 없는 경우
                // 가장 레이팅이 낮은 한국 선수를 내보낸다.
                int leastRating = koreans.firstKey();
                int count = koreans.get(leastRating);

                if (count == 1) {
                    koreans.pollFirstEntry();
                } else {
                    koreans.put(leastRating, count - 1);
                }
            } else {
                // Case 2. 그 외의 경우
                // 러시아 선수보다 레이팅이 높은 한국 선수 중 가장 레이팅이 낮은 한국 선수를 내보낸다.
                int lowerBoundRating = koreans.ceilingKey(rusRatings[i]);
                int count = koreans.get(lowerBoundRating);

                if (count == 1) {
                    koreans.remove(lowerBoundRating);
                } else {
                    koreans.put(lowerBoundRating, count - 1);
                }
                wins++;
            }
        }

        return wins;
    }

}
