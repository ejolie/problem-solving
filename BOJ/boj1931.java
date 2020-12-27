import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 회의실배정
 */
public class boj1931 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N = 0;
    static int[][] meetings;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine().trim());
        meetings = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        int answer = schedule();
        System.out.println(answer);
    }

    private static int schedule() {
        Arrays.sort(meetings, (m1, m2) -> {
            if (m1[1] != m2[1]) {
                return m1[1] - m2[1];
            }
            return m1[0] - m2[0];
        });

        int selected = 0;
        int lastEndTime = 0;
        for (int[] meeting : meetings) {
            int beginTime = meeting[0];
            int endTime = meeting[1];

            if (lastEndTime <= beginTime) {
                lastEndTime = endTime;
                selected++;
            }
        }

        return selected;
    }
}
