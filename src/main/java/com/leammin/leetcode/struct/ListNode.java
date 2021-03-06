package com.leammin.leetcode.struct;

import java.util.Objects;

/**
 * @author Leammin
 * @date 2019-04-05
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListNode listNode = (ListNode) o;
        return val == listNode.val &&
                Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }

    public static ListNode of(int... nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nodes[0]);
        ListNode tail = head;
        for (int i = 1; i < nodes.length; i++) {
            tail.next = new ListNode(nodes[i]);
            tail = tail.next;
        }
        return head;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[").append(val);
        ListNode node = this.next;
        while (node != null) {
            result.append(",").append(node.val);
            node = node.next;
        }
        return result.append("]").toString();
    }
}
