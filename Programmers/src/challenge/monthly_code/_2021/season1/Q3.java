package challenge.monthly_code._2021.season1;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 모두 0으로 만들기
 */
public class Q3 {

    public static void main(String[] args) {
        Q3 q3 = new Q3();
        assertEquals(9, q3.solution(new int[]{-5, 0, 2, 1, 2}, new int[][]{{0, 1}, {3, 4}, {2, 3}, {0, 3}}));
        assertEquals(-1, q3.solution(new int[]{0, 1, 0}, new int[][]{{0, 1}, {1, 2}}));
    }

    /**
     * Tree
     * 1) 싸이클이 없는 무방향 그래프
     * 2) 두 개의 정점 사이 반드시 한 개의 간선만 존재 -> n개의 정점, n-1개의 간선
     */
    public long solution(int[] vertices, int[][] edges) {
        if (!isZeroSum(vertices)) { // base case check: 모든 점들의 가중치를 0으로 만드는 것이 가능한지
            return -1;
        }

        int N = vertices.length;
        List<Integer>[] neighbors = new ArrayList[N]; // 연결 index만 저장
        for (int i = 0; i < N; i++) {
            neighbors[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int v = edge[0];
            int w = edge[1];
            neighbors[v].add(w);
            neighbors[w].add(v);
        }

        long[] newVertices = getNewVertices(vertices, N);

        return dfs(neighbors, newVertices, 0, -1); // neighbors root: index 0 으로 임의 설정
    }

    private boolean isZeroSum(int[] vertices) {
        long sum = 0L;
        for (int v : vertices) {
            sum += v;
        }
        return sum == 0L;
    }

    private long[] getNewVertices(int[] vertices, int N) {
        long[] newVertices = new long[N];
        for (int i = 0; i < N; i++) {
            newVertices[i] = vertices[i];
        }
        return newVertices;
    }

    /**
     * DFS: leaf node 까지 가서 부모와 작업하면서 올라온다.
     */
    private long dfs(List<Integer>[] neighbors, long[] vertices, int node, int parent) {
        if (neighbors[node].size() == 1 && node > 0) { // base case: leaf node
            return addAndSubtract(vertices, node, parent);
        }

        long totalOps = 0L;
        List<Integer> nodes = neighbors[node];
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i) != parent) {
                totalOps += dfs(neighbors, vertices, nodes.get(i), node);
            }
        }

        if (node > 0) {
            totalOps += addAndSubtract(vertices, node, parent);
        }

        return totalOps;
    }

    private long addAndSubtract(long[] vertices, int node, int parent) {
        long delta = vertices[node];
        vertices[node] -= delta;
        vertices[parent] += delta;
        return Math.abs(delta);
    }
}
