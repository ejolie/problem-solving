package com.ejolie.challenge._2020.july;

/**
 * Day21. Word Search
 */
public class Day21 {
    public static void main(String[] args) {
        char[][] board = {
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}
        };
        String word = "AAB";
        System.out.println(exist(board, word));
    }

    // static boolean[][] visited;

    public static boolean exist(char[][] board, String word) {
        // visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (check(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean check(char[][] board, int x, int y, String word, int idx) {
        if (idx == word.length()) return true;
        if (x < 0 || x == board.length || y < 0 || y == board[0].length) return false;
        if (board[x][y] != word.charAt(idx)) return false;

        board[x][y] = '*'; // visited[x][y] = true;
        if (check(board, x - 1, y, word, idx + 1) ||
                check(board, x, y + 1, word, idx + 1) ||
                check(board, x + 1, y, word, idx + 1) ||
                check(board, x, y - 1, word, idx + 1))
            return true;
        board[x][y] = word.charAt(idx); // visited[x][y] = false;

        return false;
    }
}
