package com.ejolie.easy._20;

import java.util.Stack;

/*
 * 20. Valid Parentheses
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "([)]";
        System.out.println(solution.isValid(s));
    }

    public boolean isMatch(char top, char ch2) {
        switch (top) {
            case '(':
                return ch2 == ')';
            case '[':
                return ch2 == ']';
            case '{':
                return ch2 == '}';
            default:
                return false;
        }

    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (stack.empty() || ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                char top = stack.pop();
                if (!isMatch(top, ch)) {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}
