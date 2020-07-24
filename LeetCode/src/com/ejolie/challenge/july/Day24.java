package com.ejolie.challenge.july;

import java.util.*;

/**
 * Day24. All Paths From Source to Target
 */
public class Day24 {
    public static void main(String[] args) {
        int[][] graph = {
            {1, 2},
            {3},
            {3},
            {}
        };

        List<List<Integer>> result = allPathsSourceTarget(graph);
        for (List<Integer> list : result) {
            System.out.println(list.toString());
        }
    }

    // 1. BFS
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new LinkedList<>();

        Queue<List<Integer>> q = new ArrayDeque<>();
        q.add(Arrays.asList(0));
        int lastNode = graph.length - 1;

        while (!q.isEmpty()) {
            List<Integer> path = q.poll();
            int v = path.get(path.size() - 1);
            if (v == lastNode) {
                res.add(new LinkedList<>(path));
                continue;
            }
            for (int w : graph[v]) {
                List<Integer> newPath = new LinkedList<>(path);
                newPath.add(w);
                q.add(newPath);
            }
        }

        return res;
    }

    // 2. Backtracking DFS
    public static List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        List<List<Integer>> res = new LinkedList<>();

        List<Integer> path = new LinkedList<>();
        path.add(0);
        backtrack(res, graph, 0, path);

        return res;
    }

    private static void backtrack(List<List<Integer>> res, int[][] graph, int curr, List<Integer> path) {
        if (curr == graph.length - 1) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int next : graph[curr]) {
            path.add(next);
            backtrack(res, graph, next, path);
            path.remove(path.size() - 1);
        }
    }
}
