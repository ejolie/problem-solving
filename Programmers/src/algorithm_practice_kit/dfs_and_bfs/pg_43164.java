package algorithm_practice_kit.dfs_and_bfs;

import java.util.*;

/**
 * 여행경로
 */
public class pg_43164 {
    public static void main(String[] args) {
        String[][] tickets = {
                {"ICN", "JFK"},
                {"HND", "IAD"},
                {"JFK", "HND"}
        };
        System.out.println(Arrays.toString(solution(tickets)));
    }

    // DFS
    // 1. 처음 출발지 : "ICN"
    // 2. 주어진 항공권 모두 사용
    // 3. 모든 도시를 방문해야 함
    // 4. 알파벳 순서가 앞서는 경로
    public static String[] solution(String[][] tickets) {
        String[] ans = {};
        int len = tickets.length;
        boolean[] visited = new boolean[len];
        for (int i = 0; i < len; i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];
            if (from.equals("ICN")) {
                visited[i] = true;
                dfs(tickets, visited, len, to, 1);
            }
        }
        return ans;
    }

    private static void dfs(String[][] tickets, boolean[] visited, int len, String start, int cnt) {
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
        }
    }
}