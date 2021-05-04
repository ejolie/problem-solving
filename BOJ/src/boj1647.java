import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1647. 도시 분할 계획
 */
public class boj1647 {

    static int V;
    static int E;
    static int[] parent;
    static PriorityQueue<Edge> minHeap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }
        minHeap = new PriorityQueue<>(E);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            minHeap.add(new Edge(src, dest, weight));
        }

        kruskal();
    }

    private static void kruskal() {
        int totalWeight = 0;
        int groups = V;

        for (int i = 0; i < E; i++) {
            Edge edge = minHeap.poll();
            int src = edge.src;
            int dest = edge.dest;

            if (find(src) != find(dest)) {
                union(src, dest);
                totalWeight += edge.weight;
                if (--groups == 2) {
                    break;
                }
            }
        }

        System.out.println(totalWeight);
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        parent[a] = find(parent[a]);
        return parent[a];
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int weight;

        Edge(int s, int d, int w) {
            src = s;
            dest = d;
            weight = w;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }
}
