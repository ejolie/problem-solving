package com.ejolie.challenge._2021.march;

import com.ejolie.problems.structure.ListNode;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Day4. Intersection of Two Linked Lists
 */
public class Day4 {
    // 9 ms, 44.9 MB
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        Set<ListNode> nodeSet = new LinkedHashSet<>();
        while (headA != null) {
            nodeSet.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (nodeSet.contains(headB)) {
                return headB;
            }
            nodeSet.add(headB);
            headB = headB.next;
        }

        return null;
    }
}
