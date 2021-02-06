package com.ejolie.challenge._2021.february;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.assertEquals;

/**
 * Day 5. Simplify Path
 */
public class Day5 {
    private static String UP = "..";
    private static String CURR = ".";
    private static String ROOT = "/";

    public static void main(String[] args) {
        assertEquals("/home", simplifyPath("/home/"));
        assertEquals("/", simplifyPath("/../"));
        assertEquals("/home/foo", simplifyPath("/home//foo/"));
        assertEquals("/c", simplifyPath("/a/./b/../../c/"));
        assertEquals("/", simplifyPath("/home/../../.."));
    }

    public static String simplifyPath(String path) {
        String[] paths = path.split("/");
        Deque<String> deque = new ArrayDeque<>(paths.length);

        for (String p : paths) {
            if (p.isEmpty() || CURR.equals(p)) {
                continue;
            }
            if (UP.equals(p)) {
                if (deque.size() > 1) {
                    deque.pollLast();
                    deque.pollLast();
                }
            } else {
                if (deque.isEmpty() || !ROOT.equals(deque.peekLast())) {
                    deque.addLast("/");
                }
                deque.addLast(p);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!deque.isEmpty()) {
            result.append(deque.pollFirst());
        }

        return result.length() == 0 ? "/" : result.toString();
    }
}
