package com.ejolie.easy._771;

/*
 * 771. Jewels and Stones
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String J = "aA";
        String S = "aAAbbbb";
        System.out.println(solution.numJewelsInStones(J, S));
    }

    // 1. Two for loop
    public int numJewelsInStones(String J, String S) {
        int cnt = 0;
        for (char jewel : J.toCharArray()) {
            for (char stone : S.toCharArray()) {
                if (jewel == stone) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    // 2. For loop & String.indexOf()
    public int numJewelsInStones2(String J, String S) {
        int cnt = 0;
        for (char stone : S.toCharArray()) {
            if (J.indexOf(stone) > -1) {
                cnt++;
            }
        }
        return cnt;
    }
}
