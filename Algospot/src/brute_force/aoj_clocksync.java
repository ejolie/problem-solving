package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 시계 맞추기
 * <p>
 * 1. point
 * - 스위치를 누르는 순서는 중요하지 않다. -> 순서가 달라도 결과는 같다.
 * - 각 스위치를 몇 번씩 누를 것인가만 알면 된다.
 * <p>
 * 2. 문제 변형하기
 * - 스위치를 누르는 횟수: 최소 0번, 최대 3번 (4번 누르면 제자리이므로) -> 경우의 수: 4
 * - 10개 스위치의 전체 경우의 수: 4^10
 */
public class aoj_clocksync {
    static final int INF = 9999;
    static final int SWITCHES = 10;
    static final int CLOCKS = 16;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] clocks = new int[CLOCKS];
    static int[][] switches = {
            {0, 1, 2},
            {3, 7, 9, 11},
            {4, 10, 14, 15},
            {0, 4, 5, 6, 7},
            {6, 7, 8, 10, 12},
            {0, 2, 14, 15},
            {3, 14, 15},
            {4, 5, 7, 14, 15},
            {1, 2, 3, 4, 5},
            {3, 4, 5, 9, 13}
    };

    public static void main(String[] args) throws IOException {
        int cases = Integer.parseInt(br.readLine().trim());

        while (cases-- > 0) {
            String[] line = br.readLine().trim().split(" ");
            for (int i = 0; i < CLOCKS; i++) {
                clocks[i] = Integer.parseInt(line[i]);
            }

            int answer = countSwitch(0);
            System.out.println(answer == INF ? -1 : answer);
        }
    }

    /**
     * @param switchNo 이번에 누를 스위치 번호
     * @return 남은 스위치들을 눌러 모든 시계를 12시로 맞출 수 있는 최소 횟수
     */
    public static int countSwitch(int switchNo) {
        // base case: 마지막 스위치까지 왔을 때
        if (switchNo == SWITCHES) {
            return isAllTwelve() ? 0 : INF;
        }

        // 이번 스위치를 0, 1, 2, 3번 누르는 경우 모두 시도한다.
        int result = INF;
        for (int count = 0; count < 4; count++) {
            // 재귀 호출: 다음 스위치로 이동
            result = Math.min(result, count + countSwitch(switchNo + 1));

            // switchOn 호출 시점 주의
            // - count = 0일 땐 그대로인 상태로 재귀 호출
            // - 이후 count = 1일 때를 위해 += 3
            switchOn(switchNo);
        }

        return result;
    }

    /**
     * switchNo번 스위치를 눌러 시침을 움직인다.
     */
    private static void switchOn(int switchNo) {
        for (int clockNo : switches[switchNo]) {
            clocks[clockNo] += 3;
            if (clocks[clockNo] == 15) {
                clocks[clockNo] = 3;
            }
        }
    }

    /**
     * 모든 시계가 12시를 가리키고 있는지 확인한다.
     */
    private static boolean isAllTwelve() {
        for (int time : clocks) {
            if (time != 12) {
                return false;
            }
        }
        return true;
    }
}
