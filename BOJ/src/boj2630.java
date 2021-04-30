import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 색종이 만들기
 */
public class boj2630 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n = 0;
    static char[][] map;
    static final char WHITE = '0';
    static final char BLUE = '1';

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine().trim());
        map = new char[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        int[] counts = {0, 0};
        cut(0, 0, n, counts);
        for (int count: counts) {
            System.out.println(count);
        }
    }

    public static void cut(int sr, int sc, int size, int[] counts) {
        char firstColor = map[sr][sc];
        boolean isAllSameColor = true;
        for (int r = sr; r < sr + size; r++) {
            for (int c = sc; c < sc + size; c++) {
                if (map[r][c] != firstColor) {
                    isAllSameColor = false;
                    break;
                }
            }
            if (!isAllSameColor) {
                break;
            }
        }

        if (isAllSameColor) {
            if (firstColor == WHITE) {
                counts[0]++;
            } else {
                counts[1]++;
            }
            return;
        }

        int half = size / 2;
        cut(sr, sc, half, counts);
        cut(sr, sc + half, half, counts);
        cut(sr + half, sc, half, counts);
        cut(sr + half, sc + half, half, counts);
    }
}
