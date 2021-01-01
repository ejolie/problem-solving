package com.ejolie.challenge._2020.august;

/**
 * Day5. Add and Search Word - Data structure design
 */
public class Day5 {
    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        System.out.println(obj.search("pad")); // false
        System.out.println(obj.search("bad")); // true
        System.out.println(obj.search(".ad")); // true
        System.out.println(obj.search("b..")); // true
    }

    static class WordDictionary {

        private static final int ALPHABET_SIZE = 26;

        public static class TrieNode {
            TrieNode[] children;
            boolean isEndOfWord;

            public TrieNode() {
                children = new TrieNode[ALPHABET_SIZE];
                isEndOfWord = false;
            }
        }

        private static TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.isEndOfWord = true;
        }

        public boolean search(String word) {
            return find(word.toCharArray(), root, 0);
        }

        private boolean find(char[] word, TrieNode curr, int index) {
            if (index == word.length) {
                return curr.isEndOfWord;
            }

            char ch = word[index];
            if (ch == '.') {
                for (int i = 0; i < ALPHABET_SIZE; i++) {
                    if (curr.children[i] != null && find(word, curr.children[i], index + 1)) {
                        return true;
                    }
                }
                return false;
            }
            return curr.children[ch - 'a'] != null && find(word, curr.children[ch - 'a'], index + 1);
        }
    }
}
