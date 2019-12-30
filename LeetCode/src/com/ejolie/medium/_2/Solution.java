package com.ejolie.medium._2;

import com.ejolie.structure.ListNode;

/*
 * 2. Add Two Numbers
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode l1 = new ListNode(9);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(4);

        ListNode res = solution.addTwoNumbers(l1, l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy, p = l1, q = l2;
        int carry = 0;
        while (p != null || q != null) {
            int x = p == null ? 0 : p.val;
            int y = q == null ? 0 : q.val;
            int sum = x + y + carry;
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;

            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
