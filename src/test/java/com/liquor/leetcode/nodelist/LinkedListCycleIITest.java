package com.liquor.leetcode.nodelist;

import com.liquor.common.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListCycleIITest {

    @Test
    void detectCycle() {
        var head = new Node(3);
        var node2 = new Node(2);
        var node0 = new Node(0);
        var node4 = new Node(4);
        head.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2;

        var test = new LinkedListCycleII();
        var cycle = test.detectCycle(head);
        assertEquals(cycle, node2);
    }

    @Test
    void detectCycle1() {
        var head = new Node(1);
        var node2 = new Node(2);
        head.next = node2;
        node2.next = head;

        var test = new LinkedListCycleII();
        var cycle = test.detectCycle(head);
        assertEquals(cycle, head);
    }
}