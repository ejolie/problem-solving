package com.ejolie.challenge.april;

import com.ejolie.problems.structure.ListNode;

/**
 * Day8. Middle of the Linked List
 */
public class Day8 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode result = middleNode(head);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode tail = head;
        int len = 0;
        while (tail != null) {
            len++;
            tail = tail.next;
        }

        ListNode curr = head;
        int mid = len / 2;
        while (curr != null && mid != 0) {
            mid--;
            curr = curr.next;
        }
        return curr;
    }
}
