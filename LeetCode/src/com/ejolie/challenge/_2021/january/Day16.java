package com.ejolie.challenge._2021.january;

import java.util.Arrays;
import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

/**
 * Day16. Kth Largest Element in an Array
 */
public class Day16 {
    public static void main(String[] args) {
        assertEquals(5, findKthLargest_quickSelect(new int[]{3, 2, 1, 5, 6, 4}, 2));
        assertEquals(4, findKthLargest_priorityQueue(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    // - time: O(N lg N)
    // - space: O(1)
    public static int findKthLargest_sort(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // pqueue: 1 2 2 3 3 | 4 5 5 6
    // - time: O(N lg K)
    // - space: O(K)
    public static int findKthLargest_priorityQueue(int[] nums, int k) {
        PriorityQueue<Integer> pqueue = new PriorityQueue<>(k + 1); // min priority queue
        for (int num : nums) {
            pqueue.add(num);
            if (pqueue.size() > k) {
                pqueue.poll();
            }
        }
        return pqueue.poll();
    }

    // - time: O(N) best case / O(N^2) worst case
    // - space: O(1)
    public static int findKthLargest_quickSelect(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int quickSelect(int[] nums, int left, int right, int k) {
        if (left < right) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == k) {
                return nums[k];
            } else if (pivotIndex > k) {
                return quickSelect(nums, left, pivotIndex - 1, k);
            } else {
                return quickSelect(nums, pivotIndex + 1, right, k);
            }
        }
        return nums[left];
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left - 1; // i: pivot 보다 작은 수들

        for (int j = left; j < right; j++) { // j: 위치를 결정해야 하는 애들
            if (nums[j] <= pivot) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, i + 1, right);

        return i + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
