package com.ejolie.challenge._2020.september;

import com.ejolie.problems.structure.TreeNode;

/**
 * Day8. Sum of Root To Leaf Binary Numbers
 */
public class Day8 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(0, new TreeNode(0), new TreeNode(1));
        TreeNode right = new TreeNode(1, new TreeNode(0), new TreeNode(1));
        TreeNode root = new TreeNode(1, left, right);
        System.out.println(sumRootToLeaf(root));
    }

    public static int sumRootToLeaf(TreeNode root) {
        int[] answer = {0};
        traverse(root, 0, answer);
        return answer[0];
    }

    private static void traverse(TreeNode node, int sum, int[] answer) {
        if (node != null) {
            int newSum = (sum << 1) | node.val;
            if (node.left != null) {
                traverse(node.left, newSum, answer);
            }
            if (node.right != null) {
                traverse(node.right, newSum, answer);
            }
            if (node.left == null && node.right == null) {
                answer[0] += newSum;
            }
        }
    }
}
