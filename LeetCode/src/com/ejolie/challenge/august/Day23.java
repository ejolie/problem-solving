package com.ejolie.challenge.august;

/**
 * Day23. Stream of Characters
 */
public class Day23 {
    public static void main(String[] args) {
        String[] words = {"cd","f","kl"};
        StreamChecker streamChecker = new StreamChecker(words); // init the dictionary.
        System.out.println(streamChecker.query('a'));   // return false
        System.out.println(streamChecker.query('b'));   // return false
        System.out.println(streamChecker.query('c'));   // return false
        System.out.println(streamChecker.query('d'));   // return true, because 'cd' is in the wordlist
        System.out.println(streamChecker.query('e'));   // return false
        System.out.println(streamChecker.query('f'));   // return true, because 'f' is in the wordlist
        System.out.println(streamChecker.query('g'));   // return false
        System.out.println(streamChecker.query('h'));   // return false
        System.out.println(streamChecker.query('i'));   // return false
        System.out.println(streamChecker.query('j'));   // return false
        System.out.println(streamChecker.query('k'));   // return false
        System.out.println(streamChecker.query('l'));   // return true, because 'kl' is in the wordlist
    }

    static class StreamChecker {

        private static final int ALPHABET_SIZE = 26;

        static class TrieNode {
            TrieNode[] children;
            boolean isEndOfWord;

            public TrieNode() {
                children = new TrieNode[ALPHABET_SIZE];
                isEndOfWord = false;
            }
        }

        private static TrieNode root;
        private static StringBuilder sb;

        public StreamChecker(String[] words) {
            root = new TrieNode();
            sb = new StringBuilder();
            createTrie(words);
        }

        private void createTrie(String[] words) {
            for (String word : words) {
                TrieNode curr = root;
                int len = word.length();
                for (int i = len - 1; i >= 0; i--) {
                    char ch = word.charAt(i);
                    int index = ch - 'a';
                    if (curr.children[index] == null) {
                        curr.children[index] = new TrieNode();
                    }
                    curr = curr.children[index];
                }
                curr.isEndOfWord = true;
            }
        }

        public boolean query(char letter) {
            sb.append(letter);
            TrieNode curr = root;
            for (int i = sb.length() - 1; i >= 0 && curr != null; i--) {
                char ch = sb.charAt(i);
                int index = ch - 'a';
                curr = curr.children[index];
                if (curr != null && curr.isEndOfWord) {
                    return true;
                }
            }
            return false;
        }
    }

}
