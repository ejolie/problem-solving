package com.ejolie.challenge._2020.august;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Day13. Iterator for Combination
 */
public class Day13 {
    public static void main(String[] args) {
        CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

        System.out.println(iterator.next()); // returns "ab"
        System.out.println(iterator.hasNext()); // returns true
        System.out.println(iterator.next()); // returns "ac"
        System.out.println(iterator.hasNext()); // returns true
        System.out.println(iterator.next()); // returns "bc"
        System.out.println(iterator.hasNext()); // returns false
    }

    static class CombinationIterator {

        Stack<char[]> combinations;

        public CombinationIterator(String characters, int combinationLength) {
            combinations = new Stack<>();
            helper(characters.toCharArray(), combinations, new char[combinationLength], combinationLength, 0);
        }

        private static void helper(char[] chars, List<char[]> combinations, char[] temp, int r, int depth) {
            if (r == depth) {
                combinations.add(temp);
                return;
            }
            for (int i = depth; i < chars.length; i++) {
                if (temp[i] != 0) continue;
                temp[depth] = chars[i];
                helper(chars, combinations, temp, r, depth + 1);
                temp[depth] = 0;
            }
        }

        public String next() {
            return Arrays.toString(combinations.pop());
        }

        public boolean hasNext() {
            return combinations.empty();
        }
    }
}
