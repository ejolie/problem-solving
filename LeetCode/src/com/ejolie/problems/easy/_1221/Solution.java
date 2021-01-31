package com.ejolie.problems.easy._1221;

import static org.junit.Assert.assertEquals;

/**
 * 1221. Split a String in Balanced Strings
 */
public class Solution {
    public static void main(String[] args) {
        assertEquals(4, balancedStringSplit("RLRRLLRLRL"));
        assertEquals(3, balancedStringSplit("RLLLLRRRLR"));
        assertEquals(1, balancedStringSplit("LLLLRRRR"));
        assertEquals(2, balancedStringSplit("RLRRRLLRLL"));
    }

    public static int balancedStringSplit(String s) {
        int leftCount = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                leftCount++;
            } else {
                leftCount--;
            }
            if (leftCount == 0) {
                count++;
            }
        }
        return count;
    }
}
