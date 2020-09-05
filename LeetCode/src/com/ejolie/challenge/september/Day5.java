package com.ejolie.challenge.september;

import com.ejolie.problems.structure.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Day5. All Elements in Two Binary Search Trees
 */
public class Day5 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(0, new TreeNode(-10), new TreeNode(10));
        TreeNode root2Left = new TreeNode(1, new TreeNode(0), new TreeNode(2));
        TreeNode root2Right = new TreeNode(7);
        TreeNode root2 = new TreeNode(5, root2Left, root2Right);

        List<Integer> result = getAllElements(root1, root2);
        System.out.println(result.toString());
    }

    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();

        traverse(list1, root1);
        traverse(list2, root2);

        return merge(list1, list2);
    }

    private static void traverse(List<Integer> list, TreeNode root) {
        if (root == null) return;

        if (root.left != null) traverse(list, root.left);
        list.add(root.val);
        if (root.right != null) traverse(list, root.right);
    }

    private static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> answer = new LinkedList<>();

        int l = 0, r = 0;
        while (l < list1.size() && r < list2.size()) {
            if (list1.get(l) < list2.get(r)) {
                answer.add(list1.get(l++));
            } else {
                answer.add(list2.get(r++));
            }
        }

        while (l < list1.size()) {
            answer.add(list1.get(l++));
        }
        while (r < list2.size()) {
            answer.add(list2.get(r++));
        }

        return answer;
    }
}
