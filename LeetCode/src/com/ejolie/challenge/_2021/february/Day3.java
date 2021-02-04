package com.ejolie.challenge._2021.february;

import com.ejolie.problems.structure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Day3. Linked List Cycle
 */
public class Day3 {

    public static boolean hasCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();

        while (head != null) {
            if (nodes.contains(head)) {
                return true;
            }
            nodes.add(head);
            head = head.next;
        }

        return false;
    }

    public static boolean hasCycle_twoPointer(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return false;
    }
}
