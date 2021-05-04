import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 2887. 행성 터널
 */
public class boj2887 {

    static int N;
    static int[] parent;
    static PriorityQueue<Edge> minHeap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        minHeap = new PriorityQueue<>(3 * N);

        List<Planet> X = new ArrayList<>(N);
        List<Planet> Y = new ArrayList<>(N);
        List<Planet> Z = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            X.add(new Planet(i, x));
            Y.add(new Planet(i, y));
            Z.add(new Planet(i, z));
        }

        Collections.sort(X);
        Collections.sort(Y);
        Collections.sort(Z);

        for (int i = 0; i < N - 1; i++) {
            int w1 = Math.abs(X.get(i).weight - X.get(i + 1).weight);
            int w2 = Math.abs(Y.get(i).weight - Y.get(i + 1).weight);
            int w3 = Math.abs(Z.get(i).weight - Z.get(i + 1).weight);

            minHeap.add(new Edge(X.get(i).num, X.get(i + 1).num, w1));
            minHeap.add(new Edge(Y.get(i).num, Y.get(i + 1).num, w2));
            minHeap.add(new Edge(Z.get(i).num, Z.get(i + 1).num, w3));
        }

        kruskal();
    }

    private static void kruskal() {
        int totalWeight = 0;

        while (!minHeap.isEmpty()) {
            Edge edge = minHeap.poll();

            if (find(edge.src) != find(edge.dest)) {
                totalWeight += edge.weight;
                union(edge.src, edge.dest);
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

    static class Planet implements Comparable<Planet> {
        int num;
        int weight;

        Planet(int n, int w) {
            num = n;
            weight = w;
        }

        @Override
        public int compareTo(Planet o) {
            return weight - o.weight;
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
