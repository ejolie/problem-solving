package com.ejolie.medium._215;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * 215. Kth Largest Element in an Array
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(solution.findKthLargest3(nums, k));
    }

    // 0. Arrays.sort() - O(nlogn)
    private int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // 1. QuickSelect - O(n) / worst: O(n^2)
    // - Find kth Smallest Element
    public int findKthLargest2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int low, int high, int k) {
        int pivotloc = partition(nums, low, high);
        if (k == pivotloc)
            return nums[pivotloc];
        if (k < pivotloc)
            return quickSelect(nums, low, pivotloc - 1, k);
        else
            return quickSelect(nums, pivotloc + 1, high, k);
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low; // index of smaller element
        for (int j = low; j < high; j++) {
            if (nums[j] < pivot) {
                swap(nums, j, i);
                i++;
            }
        }
        swap(nums, high, i);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 2. PriorityQueue - O(nlogk)
    public int findKthLargest3(int[] nums, int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.offer(val);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

}
