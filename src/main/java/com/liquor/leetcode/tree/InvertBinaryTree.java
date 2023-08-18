package com.liquor.leetcode.tree;

import com.liquor.common.TreeNode;

/**
 * 反转二叉树
 * <p>
 * https://leetcode.cn/problems/invert-binary-tree/
 */
public class InvertBinaryTree {

    public static void main(String[] args) {

    }

    static void invertTree(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;

        invertTree(root.left);
        invertTree(root.right);

    }
}
