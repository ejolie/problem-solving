import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1922. 네트워크 연결
 */
public class boj1922 {

    static int[] parent;
    static PriorityQueue<Edge> minHeap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

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

        int totalWeight = 0;
        for (int i = 0; i < E; i++) {
            Edge edge = minHeap.poll();
            int src = edge.src;
            int dest = edge.dest;
            if (find(src) == find(dest)) { // same parent: cycle
                continue;
            }
            union(src, dest);
            totalWeight += edge.weight;
        }
        System.out.println(totalWeight);
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

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        parent[a] = find(parent[a]);
        return parent[a];
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
