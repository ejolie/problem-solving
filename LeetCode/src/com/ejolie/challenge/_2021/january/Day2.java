package com.ejolie.challenge._2021.january;

import com.ejolie.problems.structure.TreeNode;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * Day2. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
 */
public class Day2 {
    public static void main(String[] args) {
        TreeNode original1 = new TreeNode(7, new TreeNode(4), new TreeNode(3, new TreeNode(6), new TreeNode(19)));
        TreeNode cloned1 = new TreeNode(7, new TreeNode(4), new TreeNode(3, new TreeNode(6), new TreeNode(19)));
        TreeNode target1 = cloned1.right;
        TreeNode answer1 = getTargetCopy(original1, cloned1, target1);
        assertEquals(3, answer1.val);

        TreeNode original2 = new TreeNode(7);
        TreeNode cloned2 = new TreeNode(7);
        TreeNode target2 = original2;
        TreeNode answer2 = getTargetCopy(original2, cloned2, target2);
        assertEquals(7, answer2.val);
    }

    public static final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = cloned;

        // inorder traverse
        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            if (curr.val == target.val) {
                if (findTargetCopy(curr, target)) {
                    break;
                }
            }

            curr = curr.right;
        }

        return curr;
    }

    private static boolean findTargetCopy(TreeNode cloned, TreeNode target) {
        if (cloned == null && target == null) {
            return true;
        }

        if (cloned.val != target.val) {
            return false;
        }

        return findTargetCopy(cloned.left, target.left) && findTargetCopy(cloned.right, target.right);
    }
}
