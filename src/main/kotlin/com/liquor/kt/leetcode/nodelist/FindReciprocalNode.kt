package com.liquor.kt.leetcode.nodelist

import com.liquor.kt.common.Node

/**
 * 找到链表中的倒数第k个节点
 *
 * 使用快慢指针，快指针先走k步，然后快慢指针一起走，当快指针走到头时，慢指针就是倒数第k个节点
 */
object FindReciprocalNode {

    @JvmStatic
    fun main(args: Array<String>) {
        //生成一个随机链表,包含8个节点
        val head = Node(1)
        var temp = head
        for (i in 2..6) {
            temp.next = Node(i)
            temp = temp.next!!
        }

        var p = head
        while (p.next != null) {
            println(p.value)
            p = p.next!!
        }

        println("\n")

        println(findReciprocalNode(head, 3)?.value)

        println("\n")

        removeReciprocalNode(head, 2)
    }

    private fun removeReciprocalNode(head: Node, k: Int) {
        val node = findReciprocalNode(head, k + 1)
        node?.next = node?.next?.next

        var p = head
        while (p.next != null) {
            println(p.value)
            p = p.next!!
        }
    }

    private fun findReciprocalNode(head: Node, k: Int): Node? {
        if (head.next == null) {
            return head;
        }

        if (k <= 0) {
            return null
        }

        var quick = head
        // 快指针先走k步
        for (i in 0..<k) {
            quick = quick.next!!
        }

        var slow = head
        // 快慢指针一起走
        while (quick.next != null) {
            quick = quick.next!!
            slow = slow.next!!
        }
        // 慢指针就是倒数第k个节点
        return slow
    }
}