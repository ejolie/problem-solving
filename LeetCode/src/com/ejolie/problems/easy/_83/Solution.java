package com.ejolie.problems.easy._83;

import com.ejolie.problems.structure.ListNode;

/**
 * 83. Remove Duplicates from Sorted List
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode next = curr.next;
        while (next != null) {
            if (curr.val != next.val) {
                curr = curr.next;
                next = next.next;
                continue;
            }

            if (next.next == null) {
                curr.next = null;
                next = null;
            } else {
                curr.next = next.next;
                next = next.next;
            }
        }

        return head;
    }
}
