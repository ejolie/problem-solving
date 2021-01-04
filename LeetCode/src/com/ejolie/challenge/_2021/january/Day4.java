package com.ejolie.challenge._2021.january;

import com.ejolie.problems.structure.ListNode;

/**
 * Day4. Merge Two Sorted Lists
 */
public class Day4 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);

        System.out.println(mergeTwoLists_iterative(l1, l2).toString());
        System.out.println(mergeTwoLists_iterative(null, null));
        System.out.println(mergeTwoLists_iterative(null, new ListNode(0)).toString());
    }

    public static ListNode mergeTwoLists_iterative(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 != null) {
            curr.next = l1;
        } else {
            curr.next = l2;
        }

        return dummy.next;
    }

    public static ListNode mergeTwoLists_recursive(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode curr;
        if (l1.val < l2.val) {
            curr = l1;
            curr.next = mergeTwoLists_recursive(l1.next, l2);
        } else {
            curr = l2;
            curr.next = mergeTwoLists_recursive(l1, l2.next);
        }

        return curr;
    }
}
