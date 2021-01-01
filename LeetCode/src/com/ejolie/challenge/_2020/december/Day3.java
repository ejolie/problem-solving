package com.ejolie.challenge._2020.december;

import com.ejolie.problems.structure.TreeNode;

import java.util.Stack;

/**
 * Increasing Order Search Tree
 */
public class Day3 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(1), new TreeNode(7));
        TreeNode result = increasingBST(root);
        while (result != null) {
            System.out.printf("%d - ", result.val);
            result = result.right;
        }
    }

    public static TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return root;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode newRoot = null;
        TreeNode newRootCurr = null;
        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            if (newRoot == null) {
                newRoot = new TreeNode(curr.val);
                newRootCurr = newRoot;
            } else {
                newRootCurr.right = new TreeNode(curr.val);
                newRootCurr = newRootCurr.right;
            }
            curr = curr.right;
        }

        return newRoot;
    }
}
