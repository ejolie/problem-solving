package com.ejolie.easy._1290;

/*
 * 1290. Convert Binary Number in a Linked List to Integer
 */
import com.ejolie.structure.ListNode;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        System.out.println(solution.getDecimalValue(head));
    }

    // 1. Bit shift
    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res = (res << 1) | head.val;
            head = head.next;
        }
        return res;
    }

    // 2. Multiply
    public int getDecimalValue2(ListNode head) {
        int res = 0;
        while (head != null) {
            res = res * 2 + head.val;
            head = head.next;
        }
        return res;
    }
}
