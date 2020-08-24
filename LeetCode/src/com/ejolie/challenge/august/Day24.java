package com.ejolie.challenge.august;

import com.ejolie.problems.structure.TreeNode;

import java.util.Stack;

/**Î
 * Day24. Sum of Left Leaves
 */
public class Day24 {
    public static void main(String[] args) {
        TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode root = new TreeNode(3, new TreeNode(9), right);
        System.out.println(sumOfLeftLeaves3(root));
    }

    // 1. Recursive 1
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        } else {
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }

    // 2. Recursive 2
    public static int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) return 0;

        int answer = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                answer += root.left.val;
            } else {
                answer += sumOfLeftLeaves2(root.left);
            }
        }
        answer += sumOfLeftLeaves2(root.right);

        return answer;
    }

    // 3. Iterative
    public static int sumOfLeftLeaves3(TreeNode root) {
        if (root == null) return 0;
        int answer = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    answer += node.left.val;
                } else {
                    stack.push(node.left);
                }
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return answer;
    }
}
