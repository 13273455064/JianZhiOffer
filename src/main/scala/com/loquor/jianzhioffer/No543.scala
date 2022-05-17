package com.loquor.jianzhioffer

import com.loquor.jianzhioffer.node.TreeNode

/**
 * 二叉树的最大直径
 * 每一条二叉树的「直径」长度，就是一个节点的左右子树的最大深度之和
 */
object No543 {


  def main(args: Array[String]): Unit = {
    val root = TreeNode.getInstance()
    println(diameterOfBinaryTree(root))

  }



  def diameterOfBinaryTree(root: TreeNode): Int = {
    var maxDiameter = 0
    def maxDeep(root: TreeNode): Int = {
      Option(root) match {
        case None => 0
        case Some(_) =>
          val leftDeep = maxDeep(root.left)
          val rightDeep = maxDeep(root.right)
          val thisDiameter = leftDeep + rightDeep
          maxDiameter = math.max(maxDiameter, thisDiameter)
          math.max(leftDeep, rightDeep) + 1
      }
    }
    maxDeep(root)
    maxDiameter
  }



}
