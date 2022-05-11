package com.loquor.jianzhioffer

import com.loquor.jianzhioffer.node.TreeNode

/**
 * 二叉树中和最大的路径
 */
object No124 {


  def main(args: Array[String]): Unit = {
    var maxP: Int = Int.MinValue

    def maxPathSum(root: TreeNode): Int = {
      Option.apply(root) match {
        case None => 0
        case Some(_) =>
          val leftMax = math.max(maxPathSum(root.left), 0)
          val rightMax = math.max(maxPathSum(root.right), 0)
          maxP = math.max(leftMax + rightMax + root.value, maxP)
          math.max(leftMax, rightMax) + root.value
      }
    }

    val root = TreeNode.getInstance()
    maxPathSum(root)
    println(maxP)

  }



}
