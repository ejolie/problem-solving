package com.ejolie.problems.easy._108;

import com.ejolie.problems.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode result = solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(result);

        TreeNode result2 = solution.sortedArrayToBST_iterative(new int[]{-10, -3, 0, 5, 9});
        System.out.println(result2);
    }

    // Method 1. Recursive
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeTree(nums, 0, nums.length - 1);
    }

    private TreeNode makeTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = makeTree(nums, left, mid - 1);
        root.right = makeTree(nums, mid + 1, right);
        return root;
    }

    // Method 2. Iterative
    public TreeNode sortedArrayToBST_iterative(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(0);
        Deque<Node> stack = new ArrayDeque<>();
        Node node = new Node(root, 0, nums.length - 1);
        stack.push(node);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            TreeNode treeNode = curr.node;
            int mid = curr.low + (curr.high - curr.low) / 2;
            treeNode.val = nums[mid];

            if (curr.high > mid) {
                treeNode.right = new TreeNode(0);
                stack.push(new Node(treeNode.right, mid + 1, curr.high));
            }
            if (curr.low < mid) {
                treeNode.left = new TreeNode(0);
                stack.push(new Node(treeNode.left, curr.low, mid - 1));
            }
        }
        return root;
    }

    static class Node {
        TreeNode node;
        int low;
        int high;

        Node(TreeNode n, int l, int h) {
            node = n;
            low = l;
            high = h;
        }
    }
}
