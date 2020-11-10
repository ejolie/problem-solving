package com.ejolie.challenge.november;

import com.ejolie.problems.structure.TreeNode;

/**
 * Day9. Maximum Difference Between Node and Ancestor
 */
public class Day9 {

    private static int maxDiff;

    public Day9() {
        maxDiff = 0;
    }

    public static void main(String[] args) {
        TreeNode rr = new TreeNode(0, new TreeNode(3), null);
        TreeNode r = new TreeNode(2, null, rr);
        TreeNode root = new TreeNode(1, null, r);
        System.out.println(maxAncestorDiff(root));
    }

    public static int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, root.val, root.val);
        return maxDiff;
    }

    private static void dfs(TreeNode node, int min, int max) {
        if (node == null) {
            return;
        }

        min = Math.min(node.val, min);
        max = Math.max(node.val, max);
        maxDiff = Math.max(maxDiff, max - min);

        dfs(node.left, min, max);
        dfs(node.right, min, max);
    }
}
