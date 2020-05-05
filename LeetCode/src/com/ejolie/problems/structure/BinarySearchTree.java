package com.ejolie.problems.structure;

public class BinarySearchTree {
    public TreeNode root;

    public BinarySearchTree() {
    }

    public TreeNode search(TreeNode root, int val) {
        if (root == null || root.val == val) return root;

        if (root.val > val) return search(root.left, val);

        return search(root.right, val);
    }

    public void insert(int val) {
        root = insertRec(root, val);
    }

    public TreeNode insertRec(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        if (val < root.val) {
            root.left = insertRec(root.left, val);
        } else if (val > root.val) {
            root.right = insertRec(root.right, val);
        }

        return root;
    }

    public void delete(int val) {
        root = deleteRec(root, val);
    }

    public TreeNode deleteRec(TreeNode root, int val) {
        if (root == null) return root;

        if (val < root.val) {
            root.left = deleteRec(root.left, val);
        } else if (val > root.val) {
            root.right = deleteRec(root.right, val);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            root.val = getMinValue(root.right);
            root.right = deleteRec(root.right, root.val);
        }

        return root;
    }

    private int getMinValue(TreeNode root) {
        int minValue = root.val;
        while (root.left != null) {
            minValue = root.left.val;
            root = root.left;
        }
        return minValue;
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.val);
            inorder(root.right);
        }
    }
}
