package com.ejolie.problems.easy._21;

import com.ejolie.problems.structure.ListNode;

/*
 *  21. Merge Two Sorted Lists
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode res = solution.mergeTwoLists2(l1, l2);
    }

    // 1. While loop
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0); // dummy head
        ListNode pt = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                res.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                res.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            res = res.next;
        }
        res.next = l1 == null ? l2 : l1;
        return pt.next;
    }

    // TODO: Understanding recursion
    // 2. Recursive
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            if (l1.val < l2.val) {
                l1.next = mergeTwoLists2(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists2(l1, l2.next);
                return l2;
            }
        }
    }
}
