package com.liquor.jianzhioffer.no31to40;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * <p>
 * 一开始看题还以为要深度优先遍历 然后比较值，还是太天真了
 * 大佬们的算法是利用递归，先从简单的开始想
 * 如果树只有一个节点，那么树的深度为 1
 * 如果只有左子树，那么树的深度为左子树的深度 + 1
 * 如果只有右子树，那么树的深度为右子树的深度 + 1
 * 这样，很简单就可以想到用递归的方式求解
 * <p>
 * 递归有三要素:
 * 1： 最简单的情况怎么办
 * 2： 什么时候返回
 * 3： 递归的主体是什么
 *
 * @author zzc on 2020.1.6
 */
public class No40 {
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);

        return left > right ? left + 1 : right + 1;
    }


    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
