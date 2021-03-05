package com.ejolie.challenge._2021.march;

import com.ejolie.problems.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Day5. Average of Levels in Binary Tree
 */
public class Day5 {
    public List<Double> averageOfLevels(TreeNode root) {
        Map<Integer, NodeSum> map = new LinkedHashMap<>();
        traverse(root, map, 0);

        List<Double> values = new ArrayList<>();
        for (Integer key : map.keySet()) {
            values.add(map.get(key).sum / map.get(key).count);
        }
        return values;
    }

    private void traverse(TreeNode root, Map<Integer, NodeSum> map, int level) {
        if (root == null) {
            return;
        }

        NodeSum nodeSum = map.getOrDefault(level, new NodeSum());
        nodeSum.count += 1;
        nodeSum.sum += root.val;
        map.put(level, nodeSum);

        if (root.left != null) {
            traverse(root.left, map, level + 1);
        }
        if (root.right != null) {
            traverse(root.right, map, level + 1);
        }
    }

    static class NodeSum {
        int count;
        double sum;

        public NodeSum() {

        }
    }
}
