package com.liquor.kt.leetcode.nodelist

import com.liquor.kt.common.Node

/**
 * 判断链表是否有环
 * 使用快慢指针
 */
object NodeListIsRing {

    @JvmStatic
    fun main(args: Array<String>) {
        // 生成一个随机链表,包含8个节点
        val head = Node(1)
        var temp = head
        for (i in 2..6) {
            temp.next = Node(i)
            temp = temp.next!!
        }

        //temp.next = head.next


        println(isRing(head))

    }

    private fun isRing(head: Node): Boolean {
        // 快慢指针都指向头节点
        var fast = head
        var slow = head
        // 快指针走到末尾为止
        while (fast != null && fast.next != null) {
            // 快指针走两步，慢指针走一步，如果有环最终肯定会相遇
            fast = fast.next?.next!!
            slow = slow.next!!

            if (fast == slow) {
                return true
            }
        }
        // 快指针走到末尾跳出循环，说明没有环
        return false
    }


}