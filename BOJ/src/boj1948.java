import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1948. 임계경로
 * - 모든 임계경로(critical path)를 구해야 하는 문제
 * - 도착 지점에 가기 위해 1분도 쉬지 않고 달려야 하는 사람: 가장 오랜 시간이 걸리는 사람, 즉 임계경로
 * -> 임계경로를 구한 다음, 임계경로에 속한 정점들을 구하는 문제
 */
public class boj1948 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static List<List<Edge>> go;
    static List<List<Edge>> back;
    static int[] indegree;
    static int[] dist;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        indegree = new int[N + 1];
        dist = new int[N + 1];
        visited = new boolean[N + 1];

        go = new ArrayList<>(N + 1);
        back = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; i++) {
            go.add(new ArrayList<>());
            back.add(new ArrayList<>());
        }

        StringTokenizer st;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            go.get(start).add(new Edge(end, time));
            back.get(end).add(new Edge(start, time));
            indegree[end]++;
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        topologicalSort(start);
        dfs(end);

        System.out.printf("%d\n%d", dist[N], count);
    }

    private static void topologicalSort(int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Edge e : go.get(node)) {
                dist[e.node] = Math.max(dist[e.node], dist[node] + e.time);
                if (--indegree[e.node] == 0) {
                    queue.offer(e.node);
                }
            }
        }
    }

    private static void dfs(int node) {
        visited[node] = true;
        for (Edge e : back.get(node)) {
            if (dist[e.node] == dist[node] - e.time) {
                count++;
                if (!visited[e.node]) {
                    dfs(e.node);
                }
            }
        }
    }

    static class Edge {
        int node;
        int time;

        Edge(int n, int t) {
            node = n;
            time = t;
        }
    }
}
