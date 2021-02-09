package com.ejolie.challenge._2021.february;

import com.ejolie.problems.structure.TreeNode;

import java.util.Stack;

/**
 * Day9. Convert BST to Greater Tree
 */
public class Day9 {
    private int sum = 0;

    // reverse in-order traversal
    // - time: O(n)
    // - space: O(n)
    public TreeNode convertBST_recursion(TreeNode root) {
        if (root != null) {
            convertBST_recursion(root.right);
            sum += root.val;
            root.val = sum;
            convertBST_recursion(root.left);
        }

        return root;
    }

    // - time: O(n)
    // - space: O(n)
    public TreeNode convertBST_stack(TreeNode root) {
        int sum = 0;
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.empty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.right;
            }

            curr = stack.pop();
            sum += curr.val;
            curr.val = sum;

            curr = curr.left;
        }

        return root;
    }
}
