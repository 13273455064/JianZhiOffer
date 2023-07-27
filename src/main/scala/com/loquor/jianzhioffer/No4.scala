package com.loquor.jianzhioffer

import com.loquor.common.node.TreeNode

/**
 * 剑指offer第6题
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * <p>
 * <p>
 * 前序遍历，第一个数肯定是根节点
 * 在中序遍历里面找到前序遍历的第一个数，此数左边的属于根节点的左侧孩子，右边的属于根节点的右侧孩子，剩下的递归即可
 */
object No4 {

  def main(args: Array[String]): Unit = {

    val pre = Array(1, 2, 4, 7, 3, 5, 6, 8)
    val in = Array(4, 7, 2, 1, 5, 3, 8, 6)

    val treeNode = reConstructBinaryTree(pre, in)
    println(treeNode)
  }

  def reConstructBinaryTree(pre: Array[Int], in: Array[Int]): Option[TreeNode] = {
    if (pre == null || in == null || pre.isEmpty || in.isEmpty || pre.length != in.length) None
    else reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1)
  }

  def reConstructBinaryTree(pre: Array[Int], preStart: Int, preEnd: Int, in: Array[Int], inStart: Int, inEnd: Int): Option[TreeNode] = {
    if (preStart > preEnd || inStart > inEnd) {
      return None
    }
    // 前序遍历第一个节点就是根节点
    val root = pre(preStart)
    val rootNode = TreeNode(root)
    // 中序遍历中找到根节点的位置
    val rootIndex = in.indexOf(root)
    rootNode.copy(left = reConstructBinaryTree(pre, preStart + 1, preStart + rootIndex - inStart, in, inStart, rootIndex - 1),
      right = reConstructBinaryTree(pre, preStart + rootIndex - inStart + 1, preEnd, in, rootIndex + 1, inEnd)
    )
    Some(rootNode)
  }
}
