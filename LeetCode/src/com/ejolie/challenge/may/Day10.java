package com.ejolie.challenge.may;

/**
 * Day10. Find the Town Judge
 */
public class Day10 {
    public static void main(String[] args) {
        int N = 3;
        int[][] trust = {
                {1, 3},
                {2, 3},
                {3, 1}
        };
        System.out.println(findJudge(N, trust));
    }

    public static int findJudge(int N, int[][] trust) {
        int[] inDeg = new int[N + 1];
        int[] outDeg = new int[N + 1];
        for (int[] t : trust) {
            inDeg[t[1]]++;
            outDeg[t[0]]++;
        }

        int ans = -1;
        for (int i = 1; i <= N; i++) {
            if (inDeg[i] == N - 1 && outDeg[i] == 0) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}
