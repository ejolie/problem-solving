package com.ejolie.problems.medium._347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import static org.junit.Assert.assertArrayEquals;

/**
 * 347. Top K Frequent Elements
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertArrayEquals(new int[]{1, 2}, solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        assertArrayEquals(new int[]{1}, solution.topKFrequent(new int[]{1}, 1));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>(nums.length);
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Element> maxHeap = new PriorityQueue<>(k, (o1, o2) -> Integer.compare(o2.count, o1.count));
        for (int num : counter.keySet()) {
            maxHeap.offer(new Element(counter.get(num), num));
        }

        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = maxHeap.poll().num;
        }
        return answer;
    }

    static class Element {
        int count;
        int num;

        public Element(int c, int n) {
            count = c;
            num = n;
        }
    }
}
