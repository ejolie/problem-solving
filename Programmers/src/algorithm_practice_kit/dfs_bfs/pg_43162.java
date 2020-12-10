package algorithm_practice_kit.dfs_bfs;

import java.util.*;

/**
 * 네트워크
 */
public class pg_43162 {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };
        System.out.println(solution(n, computers));
    }

    public static int solution(int n, int[][] computers) {
        int ans = 0;
        LinkedList<Integer>[] G = new LinkedList[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            G[i] = new LinkedList<>();
        }

        for (int v = 0; v < n; v++) {
            for (int w = 0; w < n; w++) {
                if (v != w && computers[v][w] == 1) {
                    G[v].add(w);
                }
            }
        }

        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                ans++;
                dfs(G, visited, n, v);
            }
        }

        return ans;
    }

    private static void dfs(LinkedList<Integer>[] G, boolean[] visited, int n, int v) {
        visited[v] = true;
        for (int w : G[v]) {
            if (!visited[w]) {
                dfs(G, visited, n, w);
            }
        }
    }

}