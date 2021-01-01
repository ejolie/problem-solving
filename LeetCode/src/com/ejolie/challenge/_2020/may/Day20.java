package com.ejolie.challenge._2020.may;

import com.ejolie.problems.structure.TreeNode;

import java.util.Stack;

/**
 * Day20. Kth Smallest Element in a BST
 */
public class Day20 {
    public static void main(String[] args) {
        TreeNode leftLeft = new TreeNode(2, new TreeNode(1), null);
        TreeNode left = new TreeNode(3, leftLeft, new TreeNode(4));
        TreeNode right = new TreeNode(6);
        TreeNode root = new TreeNode(5, left, right);
        int k = 3;

        System.out.println(kthSmallest(root, k));
    }

    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int minVal = 0;

        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.add(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            k--;
            if (k == 0) {
                minVal = curr.val;
                break;
            }
            curr = curr.right;
        }

        return minVal;
    }
}
