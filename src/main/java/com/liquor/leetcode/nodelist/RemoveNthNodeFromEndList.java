package com.liquor.leetcode.nodelist;

import com.liquor.common.Node;

/**
 * 删除链表的倒数第 n 个节点
 * <p>
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndList {

    public Node removeNthFromEnd(Node head, int n) {
        var dummy = new Node(-1);
        dummy.next = head;

        var fast = head;
        var slow = head;
        var pre = dummy;

        // 快指针先走 n 步
        for (int i = 1; i < n; i++) {
            fast = fast.next;
        }

        // 快指针走到末尾的时候，慢指针所在的就是倒数第 n 个节点
        while (fast.next != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }

        // 删除满指针所在节点
        pre.next = slow.next;

        return dummy.next;
    }
}
