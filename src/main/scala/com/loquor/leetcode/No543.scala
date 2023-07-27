package com.loquor.leetcode

import com.loquor.common.node.TreeNode

/**
 * 二叉树的最大直径
 * 每一条二叉树的「直径」长度，就是一个节点的左右子树的最大深度之和
 */
object No543 {


  def main(args: Array[String]): Unit = {
    val root = TreeNode.getInstance()
    println(diameterOfBinaryTree(Some(root)))

  }


  private def diameterOfBinaryTree(root: Option[TreeNode]): Int = {
    var maxDiameter = 0

    def maxDeep(node: Option[TreeNode]): Int = {
      node match {
        case None => 0
        case Some(currentNode) =>
          val leftDeep = maxDeep(currentNode.left)
          val rightDeep = maxDeep(currentNode.right)
          val thisDiameter = leftDeep + rightDeep
          maxDiameter = math.max(maxDiameter, thisDiameter)
          math.max(leftDeep, rightDeep) + 1
      }
    }

    maxDeep(root)
    maxDiameter
  }


}
