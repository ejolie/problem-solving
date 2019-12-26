package com.ejolie.easy._20;

import java.util.HashMap;
import java.util.Stack;

/*
 * 20. Valid Parentheses
 */
public class Solution2 {
    private HashMap<Character, Character> mappings = new HashMap<>();

    Solution2() {
        mappings.put(')', '(');
        mappings.put(']', '[');
        mappings.put('}', '{');
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String s = "([)]";
        System.out.println(solution.isValid(s));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (this.mappings.containsKey(ch)) {
                char top = stack.empty() ? '#' : stack.pop();
                if (top != this.mappings.get(ch)) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }

        return stack.empty();
    }
}
