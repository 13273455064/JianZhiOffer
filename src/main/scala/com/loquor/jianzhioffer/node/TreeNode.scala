package com.loquor.jianzhioffer.node

/**
 * <p>
 *
 * </p>
 *
 * @author zhengzhicong
 * @since 2021/8/8 3:48 下午
 */
case class TreeNode(value: Int, var left: TreeNode = null, var right: TreeNode = null) {

}

object TreeNode {

  /**
   * [-10,9,20,null,null,15,7]
   *
   *     -10
   *   9     20
   *       15   7
   */
  def getInstance(): TreeNode = {
    val node_10 = TreeNode(-10)
    val node9 = TreeNode(9)
    val node20 = TreeNode(20)
    val node15 = TreeNode(15)
    val node7 = TreeNode(7)

    node_10.left = node9
    node_10.right = node20
    node20.left = node15
    node20.right = node7
    node_10
  }
}
