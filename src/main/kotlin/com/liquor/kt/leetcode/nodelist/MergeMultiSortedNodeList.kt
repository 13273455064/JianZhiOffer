package com.liquor.kt.leetcode.nodelist

import com.liquor.kt.common.Node
import java.util.*

/**
 * 合并多个有序链表
 */
object MergeMultiSortedNodeList {

    @JvmStatic
    fun main(args: Array<String>) {
        // 生成3个有序链表
        val head1 = Node(0)
        var temp = head1
        for (i in 0 .. 3) {
            temp.next = Node(i)
            temp = temp.next!!
        }

        val head2  = Node(0)
        temp = head2
        for (i in 4 .. 6) {
            temp.next = Node(i)
            temp = temp.next!!
        }

        val head3 = Node(0)
        temp = head3
        for (i in 7 .. 9) {
            temp.next = Node(i)
            temp = temp.next!!
        }

        val list = listOf(head1, head2, head3)

        println(list)

        var node = merge(list)
        while (node.next != null) {
            println(node.value)
            node = node.next!!
        }
    }

    fun merge(list: List<Node>): Node {
        val dummy = Node(-1)
        var p = dummy


        // 优先级队列，最小堆
        val queue = PriorityQueue<Node>(list.size) { o1, o2 -> o1.value - o2.value }
        // 三个头节点入队
        list.toList().forEach(queue::add)

        while (queue.isNotEmpty()) {
            // 拉出最小的节点
            val node = queue.poll()
            // 指针指向这个节点
            p.next = node
            // 如果这个节点还有后续节点，把后续节点入队
            if (node.next != null) {
                queue.add(node.next)
            }
            // 指针向前移动
            p = p.next!!
        }
        return dummy.next!!
    }


}