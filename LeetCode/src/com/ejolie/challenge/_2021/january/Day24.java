package com.ejolie.challenge._2021.january;

import com.ejolie.problems.structure.ListNode;

import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

/**
 * Day24. Merge k Sorted Lists
 */
public class Day24 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);

        ListNode[] lists = new ListNode[3];
        lists[0] = node1;
        lists[1] = node2;
        lists[2] = node3;

        assertEquals("1->1->2->3->4->4->5->6->null", mergeKLists(lists).toString());
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (ListNode node : lists)
            if (node != null) {
                queue.add(node);
            }

        while (!queue.isEmpty()) {
            curr.next = queue.poll();
            curr = curr.next;

            if (curr.next != null) {
                queue.add(curr.next);
            }
        }

        return dummy.next;
    }
}
