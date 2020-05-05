package com.ejolie.problems.easy._206;

import com.ejolie.problems.structure.ListNode;

/*
 * 206. Reverse Linked List
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode res = solution.reverseList(head);
    }

    // 0. Iterative
    public ListNode reverseList(ListNode head) {
        ListNode curr = null;
        while (head != null) {
            ListNode newNode = new ListNode(head.val);
            if (curr == null) {
                curr = newNode;
            } else {
              newNode.next = curr;
              curr = newNode;
            }
            head = head.next;
        }
        return curr;
    }

    // 1. Iterative
    // Change the current node's next pointer to its previous element
    // - Need a pointer to store its previous element
    // - Need another pointer to store the next nod
    //   before changing the reference
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    // 2. Recursive
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
