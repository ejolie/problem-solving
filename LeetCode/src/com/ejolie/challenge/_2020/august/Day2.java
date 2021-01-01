package com.ejolie.challenge._2020.august;

import java.util.HashMap;
import java.util.Map;

/**
 * Day2. Design HashSet
 */
public class Day2 {
    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));    // returns true
        System.out.println(hashSet.contains(3));    // returns false (not found)
        hashSet.add(2);
        System.out.println(hashSet.contains(2));    // returns true
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));    // returns false (already removed)
    }

    static class MyHashSet {

        private Map<Integer, Integer> set;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            this.set = new HashMap<>();
        }

        public void add(int key) {
            if (!contains(key)) {
                int setKey = ((Integer) key).hashCode();
                set.put(setKey, key);
            }
        }

        public void remove(int key) {
            if (contains(key)) {
                int setKey = ((Integer) key).hashCode();
                set.remove(setKey);
            }
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            int setKey = ((Integer) key).hashCode();
            return set.containsKey(setKey);
        }
    }
}
