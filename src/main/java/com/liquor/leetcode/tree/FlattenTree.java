package com.liquor.leetcode.tree;

import com.liquor.common.TreeNode;

/**
 * 二叉树展开为链表
 * <p>
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenTree {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);


        // 后序位置
        // 递归，把左子树设置为右子树，把右子树接到原来左子树的最右侧节点上面去
        var left = root.left;
        var right = root.right;
        if (left == null) {
            return;
        }

        root.left = null;
        root.right = left;

        while (left.right != null) {
            left = left.right;
        }
        left.right = right;

    }
}
