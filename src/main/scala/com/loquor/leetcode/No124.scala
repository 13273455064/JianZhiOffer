package com.loquor.leetcode

import com.loquor.common.node.TreeNode

/**
 * 二叉树中和最大的路径
 */
object No124 {


  def main(args: Array[String]): Unit = {
    var maxP: Int = Int.MinValue

    def maxPathSum(node: Option[TreeNode]): Int = {
      node match {
        case None => 0
        case Some(currentNode) =>
          val leftMax = math.max(maxPathSum(currentNode.left), 0)
          val rightMax = math.max(maxPathSum(currentNode.right), 0)
          maxP = math.max(leftMax + rightMax + currentNode.value, maxP)
          math.max(leftMax, rightMax) + currentNode.value
      }
    }

    val root = TreeNode.getInstance()
    maxPathSum(Some(root))
    println(maxP)

  }


}
