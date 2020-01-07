package com.liquor.offer.no41to50;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 什么是平衡二叉树？ 平衡二叉树是为了解决二叉查找树在极度倾斜时，查找的时间复杂度退化到O(n)的问题。采用旋转树节点的方式，要求左右子树的差不能超过 1
 *
 * 莫名感觉可以跟上一题二叉树的深度联系上，在每次递归时判断左右子树的差值，如果超过1就返回false
 *
 * 一看答案，还他娘的真是，但是我这个不是最优解，需要把节点全部遍历完之后才会返回结果
 * @author zzc on 2020.1.6
 */
public class No41 {
    boolean isB = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root==null){
            return false;
        }
        TreeDepth(root);
        return isB;
    }

    public int TreeDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        if (root.left==null && root.right==null){
            return 1;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        if (left-right>1 || right-left>1){
            isB = false;
        }
        return left>right ? left+1 : right+1;
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
