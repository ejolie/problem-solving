import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1415. 게임 개발
 */
public class boj1516 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static List<List<Integer>> graph;
    static int[] indegree;
    static int[] time;
    static int[] result;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        indegree = new int[N + 1];
        time = new int[N + 1];
        result = new int[N + 1];
        graph = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int num = 1; num <= N; num++) {
            String[] strs = br.readLine().split(" ");
            int t = Integer.parseInt(strs[0]);
            time[num] = t;

            for (int i = 1; i < strs.length - 1; i++) {
                int preceding = Integer.parseInt(strs[i]);
                graph.get(preceding).add(num);
                indegree[num]++;
            }
        }

        topologicalSort();
    }

    public static void topologicalSort() {
        Deque<Integer> queue = new ArrayDeque<>();
        for (int num = 1; num <= N; num++) {
            if (indegree[num] == 0) {
                result[num] = time[num];
                queue.offer(num);
            }
        }

        while (!queue.isEmpty()) {
            int num = queue.poll();

            for (int v : graph.get(num)) {
                result[v] = Math.max(result[v], result[num] + time[v]);
                if (--indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(result[i]);
        }
    }
}
