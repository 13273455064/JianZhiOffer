package com.liquor.leetcode.nodelist;


import com.liquor.common.Node;

/**
 * 环形链表2
 * <p>
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 */
public class LinkedListCycleII {

    public Node detectCycle(Node head) {
        var fast = head;
        var slow = head;

        while (fast != null && fast.next != null) {
            // 快指针走两布
            fast = fast.next.next;
            slow = slow.next;

            // 快慢指针相遇时，说明链表有环， 此时慢指针走了 k 步，快指针走了 2k 步
            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }
        // 让快指针从头开始走
        // 假设相遇点距离环起点 m 步， 则相遇的距离 起点 k-m 步，相遇点走到环起点还需要 k -m 步
        fast = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
