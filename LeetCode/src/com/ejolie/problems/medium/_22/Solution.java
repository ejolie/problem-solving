package com.ejolie.problems.medium._22;

import java.util.LinkedList;
import java.util.List;

/**
 * 22. Generate Parentheses
 */
public class Solution {

    public static void main(String[] args) {
        List<String> result = generateParenthesis_backtracking(3);
        for (String str : result) {
            System.out.println(str);
        }
    }

    public static List<String> generateParenthesis_bruteForce(int n) {
        List<String> combinations = new LinkedList<>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }


    private static void generateAll(char[] temp, int pos, List<String> result) {
        if (pos == temp.length) {
            if (isValid(temp)) {
                result.add(new String(temp));
            }
            return;
        }

        temp[pos] = '(';
        generateAll(temp, pos + 1, result);
        temp[pos] = ')';
        generateAll(temp, pos + 1, result);
    }

    public static List<String> generateParenthesis_backtracking(int n) {
        List<String> result = new LinkedList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> res, StringBuilder sb, int open, int close, int n) {
        if (open == n && close == n) {
            res.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            backtrack(res, sb, open + 1, close, n);
            sb.setLength(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            backtrack(res, sb, open, close + 1, n);
            sb.setLength(sb.length() - 1);
        }
    }

    private static boolean isValid(char[] chars) {
        int count = 0;
        for (char ch : chars) {
            if (ch == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}
