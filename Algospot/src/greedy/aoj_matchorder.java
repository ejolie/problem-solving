package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

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
            System.out.println(answer);
        }
    }

    public static int plan() {
        int win = 0;
        Arrays.sort(rusRatings);
        Arrays.sort(korRatings);

        int korOrder = 0, rusOrder = 0;
        while (korOrder < N) {
            if (korRatings[korOrder] >= rusRatings[rusOrder]) {
                win++;
                rusOrder++;
            }
            korOrder++;
        }

        return win;
    }
}
