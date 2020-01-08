package com.ejolie.medium._1302;

import com.ejolie.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * 1302. Deepest Leaves Sum
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private int getMaxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getMaxDepth(root.right), getMaxDepth(root.left));
    }

    // 1. DFS : 1) Find max depth, 2) Get sum at max depth
    private int deepestLeavesSum(TreeNode root) {
        int maxDepth = getMaxDepth(root);
        int[] res = {0};
        findSum(root, maxDepth, 1, res);
        return res[0];
    }

    private void findSum(TreeNode root, int maxDepth, int currentDepth, int[] res) {
        if (root == null) return;
        if (currentDepth == maxDepth) {
            res[0] += root.val;
        }
        findSum(root.left, maxDepth, currentDepth + 1, res);
        findSum(root.right, maxDepth, currentDepth + 1, res);
    }

    // 2. Recursion
    private int getSumAtLevel(TreeNode root, int level) {
        if (root == null) return 0;
        if (level == 1) return root.val;
        return getSumAtLevel(root.left, level-1) + getSumAtLevel(root.right, level-1);
    }

    private int deepestLeavesSum2(TreeNode root) {
        int maxDepth = getMaxDepth(root);
        return getSumAtLevel(root, maxDepth);
    }
}
