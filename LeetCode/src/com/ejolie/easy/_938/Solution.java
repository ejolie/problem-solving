package com.ejolie.easy._938;

import com.ejolie.structure.BinarySearchTree;
import com.ejolie.structure.TreeNode;

import java.util.Stack;

/*
 * 938. Range Sum of BST
 */
public class Solution {
    int ans;

    public static void main(String[] args) {
        Solution solution = new Solution();
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(18);
        int L = 7, R = 15;
        TreeNode root = tree.root;
        System.out.println(solution.rangeSumBST(root, L, R));
    }

    // TODO: Unserstanding
    // 1. DFS (Recursive)
    public int rangeSumBST(TreeNode root, int L, int R) {
        ans = 0;
        dfsRecur(root, L, R);
        return ans;
    }

    public void dfsRecur(TreeNode node, int L, int R) {
        if (node != null) {
            if (L <= node.val && node.val <= R) {
                ans += node.val;
            } else if (L < node.val) {
                dfsRecur(node.left, L, R);
            } else if (node.val < R) {
                dfsRecur(node.right, L, R);
            }
        }
    }

    // 2. DFS (Iterative)
    public int rangeSumBST2(TreeNode root, int L, int R) {
        int ans = 0;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            if (node != null) {
                if (L <= node.val && node.val <= R)
                    ans += node.val;
                if (L < node.val)
                    s.push(node.left);
                if (node.val < R)
                    s.push(node.right);
            }
        }
        return ans;
    }

    // 3. Traverse (Recursive) for BST
    public int rangeSumBST3(TreeNode root, int L, int R) {
        if (root == null)
            return 0;

        int sum = 0;
        if (L <= root.val && root.val <= R)
            sum += root.val;
        if (L < root.val)
            sum += rangeSumBST3(root.left, L, R);
        if (root.val < R)
            sum += rangeSumBST3(root.right, L, R);
        return sum;
    }

    // 4. Traverse (Recursive)
    public int rangeSumBST4(TreeNode root, int L, int R) {
        if (root == null)
            return 0;

        int sum = rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);

        if (L <= root.val && root.val <= R)
            return sum + root.val;
        else
            return sum;
    }
}
