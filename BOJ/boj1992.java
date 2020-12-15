import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 쿼드트리
 */
public class boj1992 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n = 0;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine().trim());
        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine().trim();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        String answer = compress(0, 0, n);
        System.out.println(answer);
    }

    public static String compress(int sr, int sc, int size) {
        char firstChar = map[sr][sc];
        boolean isAllSameType = true;
        for (int r = sr; r < sr + size; r++) {
            for (int c = sc; c < sc + size; c++) {
                if (map[r][c] != firstChar) {
                    isAllSameType = false;
                    break;
                }
            }
            if (!isAllSameType) {
                break;
            }
        }

        if (isAllSameType) {
            return String.valueOf(firstChar);
        }

        int half = size / 2;
        String upperLeft = compress(sr, sc, half);
        String upperRight = compress(sr, sc + half, half);
        String lowerLeft = compress(sr + half, sc, half);
        String lowerRight = compress(sr + half, sc + half, half);

        return "(" + upperLeft + upperRight + lowerLeft + lowerRight + ")";
    }
}
