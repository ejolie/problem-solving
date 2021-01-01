package com.ejolie.challenge._2020.august;

import com.ejolie.problems.structure.ListNode;

import java.util.Stack;

/**
 * Day20. Reorder List
 */
public class Day20 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next = new ListNode(3);
        head.next = new ListNode(4);

        reorderList(head);
        System.out.println(head.toString());
    }

    public static void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        ListNode temp = head;
        while (!stack.empty()) {
            curr = temp;
            temp = curr.next;
            curr.next = stack.pop();
            curr = curr.next;
        }
    }
}
