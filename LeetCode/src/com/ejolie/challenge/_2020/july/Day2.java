package com.ejolie.challenge._2020.july;

import com.ejolie.problems.structure.TreeNode;

import java.util.*;

/**
 * Day2. Binary Tree Level Order Traversal II
 */
public class Day2 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode root = new TreeNode(3, left, right);
        List<List<Integer>> result = levelOrderBottom2(root);
        for (List<Integer> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    // 1. BFS
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                currLevel.add(currNode.val);

                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            result.add(0, currLevel);
        }

        return result;
    }

    // 2. DFS
    public static List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        levelSearch(result, root, 0);
        return result;
    }

    private static void levelSearch(List<List<Integer>> result, TreeNode currNode, int level) {
        if (currNode == null) return;
        if (level == result.size()) {
            result.add(0, new LinkedList<Integer>());
        }

        levelSearch(result, currNode.left, level + 1);
        levelSearch(result, currNode.right, level + 1);
        result.get(result.size() - level - 1).add(currNode.val);
    }
}
