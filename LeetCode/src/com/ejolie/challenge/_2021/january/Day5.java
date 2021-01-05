package com.ejolie.challenge._2021.january;

import com.ejolie.problems.structure.ListNode;

/**
 * Day5. Remove Duplicates from Sorted List II
 */
public class Day5 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        System.out.println(deleteDuplicates_twoPointer(head).toString());
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int count = 0;
        int prev = head.val;

        while (head != null) {
            if (head.val != prev) {
                if (count < 2) {
                    curr.next = new ListNode(prev);
                    curr = curr.next;
                }
                prev = head.val;
                count = 1;
            } else {
                count++;
            }
            head = head.next;
        }
        if (count < 2) {
            curr.next = new ListNode(prev);
        }

        return dummy.next;
    }

    public static ListNode deleteDuplicates_twoPointer(ListNode head) {
        // slow - track the node before the dup nodes,
        // fast - to find the last node of dups.

        ListNode dummy = new ListNode(0);
        ListNode fast = head;
        ListNode slow = dummy;
        slow.next = fast;

        while (fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                // while loop to find the last node of the dups.
                fast = fast.next;
            }

            if (slow.next != fast) {
                //  duplicates detected.
                slow.next = fast.next;  // remove the dups.
            } else {
                // no dup, move down both pointer.
                slow = slow.next;
            }
            fast = fast.next;
        }

        return dummy.next;
    }

    public static ListNode deleteDuplicates_recursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        if (head.val != head.next.val) {
            head.next = deleteDuplicates_recursive(head.next);
            return head;
        } else {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates_recursive(head.next);
        }
    }
}
