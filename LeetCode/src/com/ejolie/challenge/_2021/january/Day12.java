package com.ejolie.challenge._2021.january;

import com.ejolie.problems.structure.ListNode;

import static org.junit.Assert.assertEquals;

/**
 * Day12. Add Two Numbers
 */
public class Day12 {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(2);
        a1.next = new ListNode(4);
        a1.next.next = new ListNode(3);
        ListNode a2 = new ListNode(5);
        a2.next = new ListNode(6);
        a2.next.next = new ListNode(9);
        assertEquals("7->0->3->1->null", addTwoNumbers(a1, a2).toString());

        ListNode b1 = new ListNode(0);
        ListNode b2 = new ListNode(0);
        assertEquals("0->null", addTwoNumbers(b1, b2).toString());
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            sum %= 10;
            curr.next = new ListNode(sum);

            curr = curr.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
