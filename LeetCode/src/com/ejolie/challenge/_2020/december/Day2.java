package com.ejolie.challenge._2020.december;

import com.ejolie.problems.structure.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Linked List Random Node
 */
public class Day2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        Day2 solution = new Day2(head);

        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
    }

    private List<Integer> list;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null,
     *             so it contains at least one node.
     */
    public Day2(ListNode head) {
        list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        int index = (int) (Math.random() * list.size());
        return list.get(index);
    }
}
