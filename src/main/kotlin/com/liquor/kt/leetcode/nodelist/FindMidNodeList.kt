package com.liquor.kt.leetcode.nodelist

import com.liquor.kt.common.Node

/**
 * 找到链表的中间节点
 * https://leetcode.cn/problems/middle-of-the-linked-list/
 *
 * 也是使用快慢指针
 */
object FindMidNodeList {

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

        val mid = findMidNode(head)

        println("\n")

        println(mid)
    }

    private fun findMidNode(head: Node): Node? {
        if (head?.next == null) {
            return head
        }

        var quick = head
        var slow = head

        // 快慢指针，快指针走两步，慢指针走一步，当快指针走到头时，慢指针就是中间节点
        while (quick.next != null && quick.next!!.next != null) {
            quick = quick.next!!.next!!
            slow = slow.next!!
        }

        return slow
    }
}