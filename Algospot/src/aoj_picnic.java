import java.io.*;
import java.util.*;

/**
 * 소풍
 * 1. 재귀 호출을 이용한 완전 탐색
 * - 전체 문제를 n/2 조각으로 나눠 한 조각마다 두 학생을 짝지어 준다.
 * -> "아직 짝을 찾지 못한 학생들의 명단이 주어질 때 친구끼리 둘씩 짝짓는 경우의 수를 계산하라."
 * 2. 문제점: 경우의 수 중복 카운팅
 * - 해결방법: 항상 특정 형태를 갖는 답만 센다.
 * -> 각 단계에서 남아 있는 학생들 중 가장 번호가 빠른 학생의 짝을 찾아 주도록 한다.
 */
public class aoj_picnic {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n = 0;
    static int m = 0;
    static boolean[][] areFriends;
    static boolean[] taken;

    public static void main(String[] args) throws IOException {
        int cases = Integer.parseInt(br.readLine().trim());
        while (cases-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            areFriends = new boolean[n][n];
            taken = new boolean[n];

            st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < m; i++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                areFriends[a][b] = true;
                areFriends[b][a] = true;
            }

            int result = solution();
            System.out.println(result);
        }
    }

    public static int solution() {
        // 남은 학생들 중 가장 번호가 빠른 학생을 찾는다.
        int firstFree = -1;
        for (int i = 0; i < n; i++) {
            if (!taken[i]) {
                firstFree = i;
                break;
            }
        }

        // base case: 모든 학생이 짝을 찾은 경우
        if (firstFree == -1) {
            return 1;
        }

        // 이 학생(firstFree)과 짝지을 학생을 결정한다.
        int result = 0;
        for (int i = firstFree + 1; i < n; i++) {
            if (!taken[i] && areFriends[firstFree][i]) {
                taken[firstFree] = taken[i] = true;
                result += solution();
                taken[firstFree] = taken[i] = false;
            }
        }

        return result;
    }
}
