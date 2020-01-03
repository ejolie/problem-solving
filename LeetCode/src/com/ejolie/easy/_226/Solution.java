package com.ejolie.easy._226;

import com.ejolie.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 226. Invert Binary Tree
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    // 1. Recursive
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

    // 2. Iterative - Similar to BFS
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            node.left = right;
            node.right = left;
        }
        return root;
    }
}
