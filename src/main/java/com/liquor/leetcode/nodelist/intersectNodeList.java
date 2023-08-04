package com.liquor.leetcode.nodelist;

import com.liquor.common.Node;


/**
 * 寻找两个链表的交点
 */
public class intersectNodeList {

    public static void main(String[] args) {
        // 生成两个相交的链表
        Node headA = new Node(1);
        Node headB = new Node(2);

        Node node1 = new Node(3);
        Node node2 = new Node(4);
        Node node3 = new Node(5);

        headA.next = node1;
        headB.next = node1;
        node1.next = node2;
        node2.next = node3;

        /**
         * 1           4
         *      3
         * 2           5
         *
         */

        Node result = getIntersectionNode(headA, headB);

        System.out.println(result == null ? "null" : result.val);
    }

    private static Node getIntersectionNode(Node headA, Node headB) {
        // 两个链表但凡有一个为空，就不可能相交
        if (headA == null || headB == null) {
            return null;
        }

        var p1 = headA;
        var p2 = headB;

        while (p1 != p2) {
            // p1 先走到头，就把 p1 指向 headB, p2 同理
            // 也就是说，p1 和 p2 都走了两遍，就一定会相遇
            if (p1 ==null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }

            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }

        return p1;
    }
}
