package com.liquor.leetcode.tree;

import com.liquor.common.TreeNode;

/**
 * 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class MaxDeepOfTree {

    static int result = 0;
    static int currentDeep = 0;

    public static void main(String[] args) {
        // 构造一棵二叉树
        //     3
        // 9       20
        //      15    7
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode leftLeft = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);
        root.left = left;
        root.right = right;
        right.left = leftLeft;
        right.right = rightRight;
        var root2 = new TreeNode(1);
        var r = new TreeNode(2);
        root2.right = r;
        traverse(root2);
        System.out.println(result);
        traverse(root);
        System.out.println(result);
        System.out.println(maxDeep(root));
    }

    // 遍历的思路
    static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // 增加当前节点的深度
        currentDeep++;
        // 如果到了叶子节点，就更新最大深度
        if (root.left == null && root.right == null) {
            result = Math.max(result, currentDeep);
        }
        traverse(root.left);
        traverse(root.right);
        // 离开一个节点的时候，减小当前深度
        currentDeep--;
    }

    /**
     * 分解问题的思路
     */
    static int maxDeep(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 左子树的最大深度
        int leftDeep = maxDeep(node.left);
        // 右子树的最大深度
        int rightDeep = maxDeep(node.right);
        // 左右子树的最大深度，加上根结点就是整棵树的最大深度
        return Math.max(leftDeep, rightDeep) + 1;
    }
}
