package com.loquor.leetcode

import com.loquor.common.node.TreeNode

/**
 * 前序遍历和中序遍历还原二叉树
 */
object No105 {

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
  def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
    if (preorder.isEmpty) return null
    val rootValue = preorder.head
    val rootIndex = inorder.indexOf(rootValue)
    val root = new TreeNode(rootValue)
    //左子树的大小
    val leftSize = rootIndex

    val subPreForLeft = preorder.slice(1, leftSize + 1)
    val subInForLeft = inorder.slice(0, rootIndex)

    root.left = buildTree(subPreForLeft, subInForLeft)
    val subPreForRight = preorder.slice(leftSize + 1, preorder.length)
    val subInForRight = inorder.slice(rootIndex + 1, inorder.length)

    root.right = buildTree(subPreForRight, subInForRight)
    root
  }

  /**
   * 传递同一个数组，通过索引分割，内存占用较低
   *
   * @return
   */
  def build(preorder: Array[Int], preStart: Int, preEnd: Int, inorder: Array[Int], inStart: Int, inEnd: Int): TreeNode = {
    if (preStart > preEnd) return null
    val rootVal = preorder(preStart)
    val rootIndex = inorder.indexOf(rootVal)
    val root = TreeNode(rootVal)

    val leftSize = rootIndex - inStart

    root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, rootIndex - 1)
    root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, rootIndex + 1, inEnd)
    root
  }

}
