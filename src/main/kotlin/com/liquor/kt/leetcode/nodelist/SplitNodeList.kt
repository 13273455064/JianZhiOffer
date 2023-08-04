package com.liquor.kt.leetcode.nodelist

import com.liquor.kt.common.Node
import kotlin.random.Random

/**
 * 分隔链表
 */
object SplitNodeList {

    @JvmStatic
    fun main(args: Array<String>) {
        //生成一个随机链表,包含8个节点
        val head = Node(0)
        var temp = head
        val random = Random(1)
        for (i in 1..7) {
            temp.next = Node(random.nextInt(1, 10))
            temp = temp.next!!
        }


        var newNodeList = split(head, 5)
        while (newNodeList.next != null) {
            println(newNodeList.value)
            newNodeList = newNodeList.next!!
        }
    }

    private fun split(head: Node, k: Int): Node {
        if (head.next == null) {
            return head
        }

        // 定义两个虚拟头节点，第一个是小于k的，第二个是大于等于k的
        val dummp1 = Node(-1)
        val dummp2 = Node(-1)

        var p = head;
        var p1 = dummp1
        var p2 = dummp2

        // 遍历原链表
        while (p.next != null) {
            if (p.value < k) {
                p1.next = p
                p1 = p1.next!!
            } else {
                p2.next = p
                p2 = p2.next!!
            }

            // 把原链表的 next 断开
            val temp = p.next
            p.next = null
            p = temp!!
        }

        // 把两个链表拼接起来
        p1.next = dummp2.next

        return dummp1.next!!
    }
}