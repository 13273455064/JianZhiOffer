package com.liquor.offer.no51to60;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * 二叉树同此二叉树的镜像的关系找到了，这个题的解法也就出来了
 * 只要使用递归，判断二叉树的左子树的右子树 和 二叉树的右子树的左子树是否相同即可，同时需要考虑边界值
 *
 * @author zzc on 2020.1.29
 */
public class No59 {

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot==null){
            return true;
        }
        return isSymmetri(pRoot.left,pRoot.right);
    }

    private boolean isSymmetri(TreeNode left, TreeNode right) {
        if (left==null && right==null){
            return true;
        }
        if (left==null || right==null){
            return false;
        }
        return left.val==right.val
                && isSymmetri(left.right,right.left)
                && isSymmetri(left.left,right.right);
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
