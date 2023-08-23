package com.liquor.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现LRU，put 和 get 都是 O(1) 的时间复杂度
 * <p>
 * https://leetcode.cn/problems/lru-cache/
 */
public class LRUCache {

    private final int capacity;


    private final Map<Integer, Node> map = new HashMap<>();

    // 头节点
    private final Node head;

    //尾节点
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        var node = map.get(key);
        if (node == null) {
            return -1;
        }

        // 将 get 的 node 设置为头节点
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        var node = map.get(key);
        if (node == null) {
            var newNode = new Node(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            // 超过了容量限制, 删除尾节点
            if (map.size() > capacity) {
                Node tail = removeTail();
                map.remove(tail.key);
            }

        } else {
            node.val = value;
            moveToHead(node);
        }
    }

    private void addToHead(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private Node removeTail() {
        Node res = tail.pre;
        removeNode(res);
        return res;
    }


    // 双向链表
    private static class Node {
        int key;
        int val;
        Node pre;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
