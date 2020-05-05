package com.ejolie.problems.medium._1319;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/*
 * 1319. Number of Operations to Make Network Connected
 */
public class Solution {
    private int[] root;
    private int count;

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    // 1. Union-Find
    // 1) Perform union-find while traversing `connections`.
    //    Deduct the number of connected components when merging 2 components
    // 2-1) If 1 component : the network is fully connected, return.
    // 2-2) If connections < n-1 : no way to make the network connected.
    // 2-3) If other situations : return `the number of components - 1`.
    public int makeConnected(int n, int[][] connections) {
        count = n;
        root = IntStream.range(0, n).toArray();
        for (int[] c : connections) {
            union(c[0], c[1]);
        }
        return connections.length < n-1 ? -1 : Math.max(0, count-1);
    }

    private int find(int x) {
        while (x != root[x]) {
            x = root[x];
        }
        return x;
    }

    private void union(int x, int y) {
        int rx = find(x), ry = find(y);
        if (rx == ry) return;
        root[rx] = ry;
        --count;
    }

    // 2. Union-Find - O(n+m) (m: connections.length)
    public int makeConnected2(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int components = 0;
        for (int[] connection : connections) {
            int p1 = findParent(parent, connection[0]);
            int p2 = findParent(parent, connection[1]);
            parent[p1] = p2;
        }

        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                components++;
            }
        }
        return components - 1;
    }

    private int findParent(int[] parent, int i) {
        while (i != parent[i]) {
            i = parent[i];
        }
        return i;
    }

    // 3. DFS
    public int makeConnected3(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] connection : connections) {
            connect(graph, connection[0], connection[1]);
            connect(graph, connection[1], connection[0]);
        }

        int components = 0;
        boolean[] visited = new boolean[n];
        for (int v = 0; v < n; v++) {
            components += dfs(v, graph, visited);
        }

        return components -1;
    }

    private int dfs(int u, Map<Integer, List<Integer>> graph, boolean[] visited) {
        if (visited[u]) return 0;

        visited[u] = true;
        if (graph.get(u) == null) {
            for (int v : graph.get(u)) {
                dfs(v, graph, visited);
            }
        }

        return 1;
    }

    private void connect(Map<Integer, List<Integer>> graph, Integer v1, Integer v2) {
        if (graph.get(v1) == null) {
            graph.put(v1, new LinkedList<>());
        }
        graph.get(v1).add(v2);
    }
}
