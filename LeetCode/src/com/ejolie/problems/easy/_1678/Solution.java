package com.ejolie.problems.easy._1678;

import static org.junit.Assert.assertEquals;

/**
 * 1678. Goal Parser Interpretation
 */
public class Solution {

    public static void main(String[] args) {
        assertEquals("Goal", interpret("G()(al)"));
        assertEquals("Gooooal", interpret("G()()()()(al)"));
        assertEquals("alGalooG", interpret("(al)G(al)()()G"));
    }

    public static String interpret(String command) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < command.length()) {
            if (command.charAt(i) == 'G') {
                result.append("G");
                i += 1;
            } else if (command.charAt(i + 1) == ')') {
                result.append("o");
                i += 2;
            } else {
                result.append("al");
                i += 4;
            }
        }
        return result.toString();
    }
}
