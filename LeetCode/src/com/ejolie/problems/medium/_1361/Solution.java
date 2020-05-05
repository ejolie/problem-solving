package com.ejolie.problems.medium._1361;

/*
 * 1361. Validate Binary Tree Nodes
 */
public class Solution {
    public static void main(String[] args) {
        int n = 4;
        int[] leftChild = {1, -1, 3, -1};
        int[] rightChild = {2, -1, -1, -1};
        System.out.println(validateBinaryTreeNodes(n, leftChild, rightChild));
    }

    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] inDeg = new int[n];
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) inDeg[leftChild[i]]++;
            if (rightChild[i] != -1) inDeg[rightChild[i]]++;
        }

        int rootCnt = 0;
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0) rootCnt++;
            else if (inDeg[i] > 1) return false;
        }
        if (rootCnt != 1) return false;
        return true;
    }

}
