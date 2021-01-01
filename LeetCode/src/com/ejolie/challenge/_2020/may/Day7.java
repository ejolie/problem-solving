package com.ejolie.challenge._2020.may;

import com.ejolie.problems.structure.TreeNode;

/**
 * Day7. Cousins in Binary Tree
 */
public class Day7 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, null, new TreeNode(4));
        TreeNode right = new TreeNode(3, null, new TreeNode(5));
        TreeNode root = new TreeNode(1, left, right);
        int x = 5;
        int y = 4;
        System.out.println(isCousins(root, x, y));
    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        int xDepth = getDepth(root, x, 0);
        int yDepth = getDepth(root, y, 0);
        if (xDepth != yDepth) return false;

        TreeNode xParent = getParent(root, x, null);
        TreeNode yParent = getParent(root, y, null);
        if (xParent == yParent) return false;
        return true;
    }

    private static int getDepth(TreeNode root, int x, int depth) {
        if (root == null) return 0;
        if (root.val == x) return depth;
        int leftDepth = getDepth(root.left, x, depth + 1);
        int rightDepth = getDepth(root.right, x, depth + 1);
        return leftDepth == 0 ? rightDepth : leftDepth;
    }

    private static TreeNode getParent(TreeNode root, int x, TreeNode prev) {
        if (root == null) return null;
        if (root.val == x) return prev;
        TreeNode leftParent = getParent(root.left, x, root);
        TreeNode rightParent = getParent(root.right, x, root);
        return leftParent == null ? rightParent : leftParent;
    }
}
