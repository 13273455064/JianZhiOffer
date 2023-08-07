package com.liquor.leetcode.tree;

import com.liquor.common.TreeNode;

/**
 * 二叉树的最大直径
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * 所谓直径就是两个节点之间的最长路径，可能经过也可能不经过根节点
 * 也就是说，最大直径 = max(左子树的最大直径，右子树的最大直径，左子树的最大深度 + 右子树的最大深度)
 */
public class MaxDiameterOfTree {

    static int result = 0;

    public static void main(String[] args) {
        // 构造一个二叉树
        //    9
        //         1
        //      2     3
        //   4     5
        var root = new TreeNode(9);
        var left = new TreeNode(1);
        var right = new TreeNode(3);
        var leftLeft = new TreeNode(2);
        var leftRight = new TreeNode(5);
        var leftLeftLeft = new TreeNode(4);
        root.left = left;
        root.right = right;
        left.left = leftLeft;
        left.right = leftRight;
        leftLeft.left = leftLeftLeft;
        System.out.println(maxDiameter(root));
    }

    private static int maxDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = maxDiameter(root.left);
        int maxRight = maxDiameter(root.right);
        result = Math.max(result, maxLeft + maxRight);
        // 左子树的最大直径 + 右子树的最大直径 + 当前节点
        return Math.max(maxLeft, maxRight) + 1;
    }
}
