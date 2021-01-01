package com.ejolie.challenge.december;

import com.ejolie.problems.structure.TreeNode;

/**
 * Maximum Depth of Binary Tree
 */
public class Day1 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode root = new TreeNode(3, left, right);
        System.out.println(maxDepth_recursive(root));
    }

    public static int maxDepth_recursive(TreeNode root) {
        return traverse(root, 1);
    }

    private static int traverse(TreeNode root, int currDepth) {
        if (root == null) {
            return 0;
        }

        int depth = currDepth;
        if (root.left != null) {
            depth = Math.max(depth, traverse(root.left, currDepth + 1));
        }
        if (root.right != null) {
            depth = Math.max(depth, traverse(root.right, currDepth + 1));
        }

        return depth;
    }
}
