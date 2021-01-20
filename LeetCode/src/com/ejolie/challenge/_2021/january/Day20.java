package com.ejolie.challenge._2021.january;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Day20. Valid Parentheses
 */
public class Day20 {
    private static Map<Character, Character> mappings;

    static {
        mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put(']', '[');
        mappings.put('}', '{');
    }

    public static void main(String[] args) {
        assertTrue(isValid("()"));
        assertTrue(isValid("()[]{}"));
        assertTrue(isValid("{[]}"));
        assertFalse(isValid("{"));
        assertFalse(isValid("(]"));
        assertFalse(isValid("([)]"));
        assertFalse(isValid("]"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char p = s.charAt(i);
            if (stack.empty() || p == '(' || p == '[' || p == '{') {
                stack.push(p);
            } else {
                if (doesMatch(stack.peek(), p)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    private static boolean doesMatch(char left, char right) {
        if (left == '(' && right == ')') {
            return true;
        } else if (left == '[' && right == ']') {
            return true;
        }
        return left == '{' && right == '}';
    }

    public static boolean isValid_hashMap(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char p = s.charAt(i);
            if (mappings.containsKey(p)) {
                if (!stack.empty() && mappings.get(p) == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(p);
            }
        }

        return stack.empty();
    }
}
