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

  /**
   * 3
   * 9    20
   * 15   7
   */


  def main(args: Array[String]): Unit = {
    val preorder: Array[Int] = Array(3, 9, 20, 15, 7)
    val inorder: Array[Int] = Array(9, 3, 15, 20, 7)
    val root = buildTree(preorder, inorder)
    val root2 = build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1)
    println(root)
    println(root2)
  }

  /**
   * 使用了数组分割，内存占用较高
   *
   * @return
   */
  private def buildTree(preorder: Array[Int], inorder: Array[Int]): Option[TreeNode] = {
    if (preorder.isEmpty) return None

    val rootValue = preorder.head
    val rootIndex = inorder.indexOf(rootValue)
    var root = new TreeNode(rootValue)
    //左子树的大小
    val leftSize = rootIndex

    val subPreForLeft = preorder.slice(1, leftSize + 1)
    val subInForLeft = inorder.slice(0, rootIndex)

    root = root.copy(left = buildTree(subPreForLeft, subInForLeft))
    val subPreForRight = preorder.slice(leftSize + 1, preorder.length)
    val subInForRight = inorder.slice(rootIndex + 1, inorder.length)

    root = root.copy(right = buildTree(subPreForRight, subInForRight))
    Some(root)
  }

  /**
   * 传递同一个数组，通过索引分割，内存占用较低
   *
   * @return
   */
  private def build(preorder: Array[Int], preStart: Int, preEnd: Int, inorder: Array[Int], inStart: Int, inEnd: Int): Option[TreeNode] = {
    if (preStart > preEnd) return null
    val rootVal = preorder(preStart)
    val rootIndex = inorder.indexOf(rootVal)
    var root = TreeNode(rootVal)

    val leftSize = rootIndex - inStart

    root = root.copy(left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, rootIndex - 1))
    root = root.copy(right = build(preorder, preStart + leftSize + 1, preEnd, inorder, rootIndex + 1, inEnd))
    Some(root)
  }
}
