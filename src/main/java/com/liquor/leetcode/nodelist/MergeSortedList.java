package com.liquor.leetcode.nodelist;


import com.liquor.common.Node;

/**
 * 合并两个有序链表
 */
public class MergeSortedList {

    public static void main(String[] args) {
        //1->2->4, 1->3->4
        Node l1 = new Node(1, new Node(2, new Node(4)));
        Node l2 = new Node(1, new Node(3, new Node(4)));

        Node node = mergeTwoLists(l1, l2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    static Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        Node dump = new Node(-1);
        Node node = dump;


        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }

        if (l1 != null) {
            node.next = l1;
        }

        if (l2 != null) {
            node.next = l2;
        }

        return dump.next;
    }
}
