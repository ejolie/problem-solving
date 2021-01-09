package com.ejolie.challenge._2021.january;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Day9. Word Ladder
 */
public class Day9 {
    public static void main(String[] args) {
        List<String> wordList1 = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        assertEquals(5, ladderLength("hit", "cog", wordList1));

        List<String> wordList2 = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        assertEquals(0, ladderLength("hit", "cog", wordList2));

        List<String> wordList3 = new ArrayList<>(Arrays.asList("hot", "dog"));
        assertEquals(0, ladderLength("hot", "dog", wordList3));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();
        wordList.add(beginWord);
        
        for (String word1 : wordList) {
            for (String word2 : wordList) {
                int count = 0;
                for (int i = 0; i < word2.length(); i++) {
                    if (word1.charAt(i) == word2.charAt(i)) {
                        count++;
                    }
                }
                if (count == word2.length() - 1) {
                    List<String> list = map.getOrDefault(word1, new LinkedList<>());
                    list.add(word2);
                    map.put(word1, list);
                }
            }
        }

        if (map.size() == 0) {
            return 0;
        }

        Set<String> visited = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(beginWord, 1));
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (endWord.equals(node.word)) {
                return node.dist;
            }

            List<String> words = map.get(node.word);
            if (words == null) {
                return 0;
            }

            for (String word : words) {
                if (!visited.contains(word)) {
                    queue.add(new Node(word, node.dist + 1));
                    visited.add(word);
                }
            }
        }

        return 0;
    }

    static class Node {
        String word;
        int dist;

        public Node(String word, int dist) {
            this.word = word;
            this.dist = dist;
        }
    }
}
