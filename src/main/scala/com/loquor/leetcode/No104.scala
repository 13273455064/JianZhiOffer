package com.loquor.leetcode

import com.loquor.common.node.TreeNode

/**
 * 二叉树的最大深度
 */
object No104 {

  var res = 0
  //当前递归到的节点深度
  var deep = 0

  def main(args: Array[String]): Unit = {

    val root = TreeNode.getInstance()
    travers(root)
    println(res)

    println(maxDeep(root))

  }

  def maxDeep(root: TreeNode): Int = {
    Option(root) match {
      case None => 0
      case Some(_) =>
        val leftMax = maxDeep(root.left)
        val rightMax = maxDeep(root.right)
        val res = math.max(leftMax, rightMax) + 1
        res
    }
  }

  def travers(root: TreeNode): Unit = {
    Option(root) match {
      case None =>
      case Some(_) =>
        deep = deep + 1
        if (root.left == null || root.right == null) {
          res = math.max(res, deep)
        }
        travers(root.left)
        travers(root.right)
        deep = deep - 1
    }
  }


}
