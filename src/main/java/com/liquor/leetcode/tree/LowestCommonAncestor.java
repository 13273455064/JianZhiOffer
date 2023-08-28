package com.liquor.leetcode.tree;

import com.liquor.common.TreeNode;

/**
 * 二叉树的最近公共祖先
 * <p>
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        var left = lowestCommonAncestor(root.left, p, q);
        var right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {
            return null;
        }
        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;

    }
}
