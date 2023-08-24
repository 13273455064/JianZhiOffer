package com.liquor.leetcode.nodelist;

import com.liquor.common.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class RemoveNthNodeFromEndListTest {

    @Test
    void removeNthFromEnd() {
        var head = new Node(1);
        var node2 = new Node(2);
        var node3 = new Node(3);
        var node4 = new Node(4);
        var node5 = new Node(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        var res = new RemoveNthNodeFromEndList().removeNthFromEnd(head, 2);
        var except = List.of(1, 2, 3, 5);

        var actual = new ArrayList<>();
        while (res != null) {
            actual.add(res.val);
            res = res.next;
        }
        Assertions.assertEquals(except, actual);
    }

    @Test
    void removeNthFromEnd1() {
        var head = new Node(1);

        var res = new RemoveNthNodeFromEndList().removeNthFromEnd(head, 1);

        Assertions.assertEquals(null, res);
    }
}