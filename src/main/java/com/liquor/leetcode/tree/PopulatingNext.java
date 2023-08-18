package com.liquor.leetcode.tree;

import java.util.LinkedList;

/**
 * 二叉树填充填充每个节点的下一个右侧节点指针
 * <p>
 * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
 */
public class PopulatingNext {

    static class Node {
        int val;
        Node left;
        Node right;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 生成一个完美二叉树
        var root = new Node(1);
        var left = new Node(2);
        var right = new Node(3);
        root.left = left;
        root.right = right;
        var left1 = new Node(4);
        var right1 = new Node(5);
        left.left = left1;
        left.right = right1;
        var left2 = new Node(6);
        var right2 = new Node(7);
        right.left = left2;
        right.right = right2;

        connect(root);
    }

    static void connect(Node root) {
        var queue = new LinkedList<Node>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            var size = queue.size();
            for (int i = 0; i < size; i++) {
                var node = queue.poll();
                if (node != null) {
                    if (i != size - 1) {
                        node.next = queue.peek();
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
        }
    }

}
