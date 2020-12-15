package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 게임판 덮기 (난이도: 하)
 */
public class aoj_boardcover {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int h = 0;
    static int w = 0;
    static int[][] board;
    // 주어진 칸을 덮을 수 있는 네 가지 방법
    // - 블록을 구성하는 세 칸의 상대적 위치(dr, dc)
    static int[][][] coverType = {
            {{0, 0}, {1, 0}, {0, 1}}, // case 1. 「
            {{0, 0}, {0, 1}, {1, 1}}, // case 2. ㄱ
            {{0, 0}, {1, 0}, {1, 1}}, // case 3. ㄴ
            {{0, 0}, {1, 0}, {1, -1}} // case 4. 」
    };

    public static void main(String[] args) throws IOException {
        int cases = Integer.parseInt(br.readLine().trim());

        while (cases-- > 0) {
            String[] hw = br.readLine().trim().split(" ");
            h = Integer.parseInt(hw[0]);
            w = Integer.parseInt(hw[1]);
            board = new int[h][w];

            int whites = 0;
            for (int i = 0; i < h; i++) {
                String str = br.readLine().trim();
                for (int j = 0; j < w; j++) {
                    if (str.charAt(j) == '#') {
                        board[i][j] = 1; // black
                    } else {
                        board[i][j] = 0; // white
                        whites++;
                    }
                }
            }

            int result = 0;
            if (whites % 3 == 0) {
                result = cover();
            }
            System.out.println(result);
        }
    }

    /**
     * board의 모든 빈 칸을 덮을 수 있는 방법의 수를 반환한다.
     * - board[i][j] == 1: 이미 덮인 칸 or 검은 칸
     * - board[i][j] == 0: 아직 덮이지 않은 칸
     */
    public static int cover() {
        // 특정 순서대로 블록을 놓도록 강제한다.
        // (답을 한 가지 방법으로밖에 생성할 수 밖에 없으므로 중복 카운팅 문제 해결)
        // -> 아직 채우지 못한 칸 중 가장 윗줄 왼쪽에 있는 칸을 찾는다.
        int r = -1;
        int c = -1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    r = i;
                    c = j;
                    break;
                }
            }
            if (r != -1) {
                break;
            }
        }

        // base case: 채울 칸이 없는 경우(모든 칸을 채웠거나 모든 칸이 검은 칸인 경우) 1을 반환한다.
        if (r == -1) {
            return 1;
        }

        int result = 0;
        for (int type = 0; type < 4; type++) {
            // 만약 board[r][c]를 type 형태로 덮을 수 있으면 재귀 호출한다.
            boolean isOk = set(r, c, type, 1);
            if (isOk) {
                result += cover();
            }
            // 덮었던 블록을 치운다.
            set(r, c, type, -1);
        }

        return result;
    }

    /**
     * board의 (r,c)를 type번 방법으로 덮거나, 덮었던 블록을 없앤다.
     * - delta == 1: 블록을 덮는다.
     * - delta == -1: 블록을 없앤다.
     * 만약 블록이 제대로 덮이지 않은 경우(board 밖으로 나가거나, 겹치거나, 검은 칸을 덮을 때)
     * false를 반환한다.
     */
    private static boolean set(int r, int c, int type, int delta) {
        boolean isOk = true;

        for (int i = 0; i < 3; i++) {
            int nr = r + coverType[type][i][0];
            int nc = c + coverType[type][i][1];

            if (nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length) {
                isOk = false;
            } else if ((board[nr][nc] += delta) > 1) {
                isOk = false;
            }
        }

        return isOk;
    }

}
