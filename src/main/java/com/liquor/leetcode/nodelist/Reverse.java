package com.liquor.leetcode.nodelist;

import com.liquor.common.Node;

/**
 * 反转链表
 * <p>
 * https://leetcode.cn/problems/reverse-linked-list/
 */
public class Reverse {

    public static void main(String[] args) {
        var head = new Node(1);
        var node1 = new Node(2);
        var node2 = new Node(3);
        var node3 = new Node(4);
        var node4 = new Node(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Node reverse = reverse(head);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }

    }

    static Node reverse(Node head) {

        // 如果头节点为空或者只有一个节点，直接返回
        if (head == null || head.next == null) {
            return head;
        }
        var lastHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return lastHead;

    }

}
