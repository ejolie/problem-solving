package com.ejolie.challenge._2021.february;

import com.ejolie.problems.structure.TreeNode;

/**
 * Day2. Trim a Binary Search Tree
 */
public class Day2 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.val >= low && root.val <= high) {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        } else if (root.val < low) {
            return trimBST(root.right, low, high);
        } else { // root.val > high
            return trimBST(root.left, low, high);
        }

        return root;
    }
}
