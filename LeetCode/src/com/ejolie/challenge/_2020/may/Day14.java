package com.ejolie.challenge._2020.may;

/**
 * Day14. Implement Trie (Prefix Tree)
 */
public class Day14 {

    private static final int ALPHABET_SIZE = 26;

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");   // returns true
        trie.search("app");     // returns false
        trie.startsWith("app"); // returns true
        trie.insert("app");
        trie.search("app");     // returns true
    }

    public static class Trie {
        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode curr = root;

            for (int level = 0; level < word.length(); level++) {
                int index = word.charAt(level) - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }

            curr.isEndOfWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode curr = root;

            for (int level = 0; level < word.length(); level++) {
                int index = word.charAt(level) - 'a';
                if (curr.children[index] == null) {
                    return false;
                }
                curr = curr.children[index];
            }

            return (curr != null && curr.isEndOfWord);
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode curr = root;

            for (int level = 0; level < prefix.length(); level++) {
                int index = prefix.charAt(level) - 'a';
                if (curr.children[index] == null) {
                    return false;
                }
                curr = curr.children[index];
            }

            return true;
        }
    }

    private static class TrieNode {
        private TrieNode[] children;
        private boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[ALPHABET_SIZE];
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }
}
