package com.loquor.leetcode

import com.loquor.common.node.TreeNode

/**
 * 二叉树的最大深度
 */
object No104 {

  var res = 0
  //当前递归到的节点深度
  private var currentDeep = 0

  def main(args: Array[String]): Unit = {

    val root = TreeNode.getInstance()
    travers(Some(root))
    println(res)

    println(maxDeep(Some(root)))

  }

  def maxDeep(node: Option[TreeNode]): Int = {
    node match {
      case None => 0
      case Some(currentNode) =>
        val leftMax = maxDeep(currentNode.left)
        val rightMax = maxDeep(currentNode.right)
        val res = math.max(leftMax, rightMax) + 1
        res
    }
  }

  private def travers(node: Option[TreeNode]): Unit = {
    node match {
      case None =>
      case Some(currentNode) =>
        currentDeep = currentDeep + 1
        if (currentNode.left.isEmpty || currentNode.right.isEmpty) {
          res = math.max(res, currentDeep)
        }
        travers(currentNode.left)
        travers(currentNode.right)
        currentDeep = currentDeep - 1
    }
  }


}
