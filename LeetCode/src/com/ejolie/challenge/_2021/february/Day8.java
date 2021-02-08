package com.ejolie.challenge._2021.february;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Day8. Peeking Iterator
 */
public class Day8 {

    static class PeekingIterator implements Iterator<Integer> {
        Integer next;
        Iterator<Integer> iterator;
        boolean doesExistNext;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
            advanceIterator();
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return next;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (doesExistNext) {
                throw new NoSuchElementException();
            }
            Integer prev = next;
            advanceIterator();
            return prev;
        }

        @Override
        public boolean hasNext() {
            return !doesExistNext;
        }

        private void advanceIterator() {
            if (iterator.hasNext()) {
                next = iterator.next();
            } else {
                doesExistNext = true;
            }
        }
    }
}
