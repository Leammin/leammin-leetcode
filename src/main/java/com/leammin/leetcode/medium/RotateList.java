package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.ListNode;

/**
 * 61. 旋转链表
 * 
 * <p>给定一个链表，旋转链表，将链表每个节点向右移动&nbsp;<em>k&nbsp;</em>个位置，其中&nbsp;<em>k&nbsp;</em>是非负数。</p>
 * 
 * <p><strong>示例&nbsp;1:</strong></p>
 * 
 * <pre><strong>输入:</strong> 1-&gt;2-&gt;3-&gt;4-&gt;5-&gt;NULL, k = 2
 * <strong>输出:</strong> 4-&gt;5-&gt;1-&gt;2-&gt;3-&gt;NULL
 * <strong>解释:</strong>
 * 向右旋转 1 步: 5-&gt;1-&gt;2-&gt;3-&gt;4-&gt;NULL
 * 向右旋转 2 步: 4-&gt;5-&gt;1-&gt;2-&gt;3-&gt;NULL
 * </pre>
 * 
 * <p><strong>示例&nbsp;2:</strong></p>
 * 
 * <pre><strong>输入:</strong> 0-&gt;1-&gt;2-&gt;NULL, k = 4
 * <strong>输出:</strong> <code>2-&gt;0-&gt;1-&gt;NULL</code>
 * <strong>解释:</strong>
 * 向右旋转 1 步: 2-&gt;0-&gt;1-&gt;NULL
 * 向右旋转 2 步: 1-&gt;2-&gt;0-&gt;NULL
 * 向右旋转 3 步:&nbsp;<code>0-&gt;1-&gt;2-&gt;NULL</code>
 * 向右旋转 4 步:&nbsp;<code>2-&gt;0-&gt;1-&gt;NULL</code></pre>
 * 
 * 
 * @author Leammin
 * @date 2020-06-17
 */
public interface RotateList {
    ListNode rotateRight(ListNode head, int k);

    class Solution implements RotateList {

        @Override
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || k == 0) {
                return head;
            }
            ListNode node = head;
            ListNode tail = head;
            int size = 0;
            while (node != null) {
                size++;
                tail = node;
                node = node.next;
            }
            k = k % size;
            if (k == 0) {
                return head;
            }
            node = head;
            for (int i = k + 1; i < size; i++) {
                node = node.next;
            }
            ListNode newHead = node.next;
            node.next = null;
            tail.next = head;
            return newHead;
        }


    }
}
