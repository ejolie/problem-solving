import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 2252. 줄 세우기
 */
public class boj2252 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N = 0;
    static int M = 0;
    static List<List<Integer>> graph;
    static int[] indegree;

    public static void main(String[] args) throws IOException {
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        graph = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        indegree = new int[N + 1];

        while (M-- > 0) {
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);

            graph.get(a).add(b);
            indegree[b]++;
        }

        topologicalSort();
    }

    private static void topologicalSort() {
        Deque<Integer> queue = new ArrayDeque<>();
        List<String> result = new ArrayList<>();

        for (int v = 1; v <= N; v++) {
            if (indegree[v] == 0) {
                queue.offer(v);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(String.valueOf(node));

            for (int v : graph.get(node)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        System.out.println(String.join(" ", result));
    }
}
