package com.liquor.jianzhioffer.no1to10;

import java.util.ArrayList;
import java.util.Stack;

public class No3 {
    /**
     * 输入一个链表的头结点，从尾到头反过来打印出每个结点的值
     */
    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        ListNode ln6 = new ListNode(6);
        ListNode ln7 = new ListNode(7);
        ListNode ln8 = new ListNode(8);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = ln6;
        ln6.next = ln7;
        ln7.next = ln8;
        ln8.next = null;

        printListFromTailToHead(ln1);
        print(ln1);
        String s;
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        if (listNode == null) {
            return result;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        while (listNode != null) {
            stack.push(listNode);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop().val);
        }
        return result;
    }

    static int[] print(ListNode head) {
        ListNode pre = null;
        ListNode current = head;

        int size = 0;
        while (current != null) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
            size++;
        }
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = pre.val;
            pre = pre.next;
        }
        return result;
    }


    //自定义的链表内部类
    static class ListNode {
        int val;
        //指向下一个节点的指针
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }


    }

}
