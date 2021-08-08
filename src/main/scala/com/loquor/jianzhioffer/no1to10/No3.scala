package com.loquor.jianzhioffer.no1to10

import com.loquor.jianzhioffer.node.Node

/**
 * <p>
 *  反转链表
 * </p>
 *
 * @author zhengzhicong
 * @since 2021/8/8 2:21 下午
 */
object No3 {

  def main(args: Array[String]): Unit = {
    val node: Node = Node(1)
    val node2: Node = Node(2)
    val node3: Node = Node(3)
    val node4: Node = Node(4)
    val node5: Node = Node(5)
    node.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    var reversed: Node = reverse(node)
    while (reversed != null) {
      println(reversed.value)
      reversed = reversed.next
    }
  }

  def reverse( node: Node): Node = {
    var pre: Node = null
    var current = node

    while (current != null) {
      val temp = current.next
      current.next = pre
      pre = current
      current = temp
    }
    pre
  }

}
