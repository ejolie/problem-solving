package com.ejolie.learn.binarytree._144;

import com.ejolie.problems.structure.TreeNode;

import java.util.*;

/**
 * 144. Binary Tree Preorder Traversal
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode right = new TreeNode(2, new TreeNode(3), null);
        TreeNode root = new TreeNode(1, null, right);

        List<Integer> result = preorderTraversal3(root);
        for (int val : result) {
            System.out.println(val);
        }
    }

    // 1. Recursive
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();

        if (root == null) return nodes;
        nodes.add(root.val);
        nodes.addAll(preorderTraversal(root.left));
        nodes.addAll(preorderTraversal(root.right));

        return nodes;
    }

    // 2. Iterative
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        Stack<TreeNode> toVisit = new Stack<>();
        toVisit.push(root);
        while (!toVisit.isEmpty()) {
            TreeNode visiting = toVisit.pop();
            nodes.add(visiting.val);
            if (visiting.right != null) toVisit.push(visiting.right);
            if (visiting.left != null) toVisit.push(visiting.left);
        }
        return nodes;
    }

    // 3. Iterative
    public static List<Integer> preorderTraversal3(TreeNode node) {
        List<Integer> nodes = new ArrayList<>();
        Stack<TreeNode> rights = new Stack<>();
        while (node != null) {
            nodes.add(node.val);
            if (node.right != null) rights.push(node.right);
            node = node.left;
            if (node == null && !rights.isEmpty()) {
                node = rights.pop();
            }
        }
        return nodes;
    }
}
