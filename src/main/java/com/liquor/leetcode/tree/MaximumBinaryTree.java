package com.liquor.leetcode.tree;

import com.liquor.common.TreeNode;

/**
 * 最大二叉树
 * <p>
 * https://leetcode.cn/problems/maximum-binary-tree/
 */
public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        var left = 0;
        var right = nums.length - 1;

        return build(nums, left, right);
    }

    TreeNode build(int[] nums, int left, int right) {
        var max = -1;
        var maxIndex = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        if (max < 0) {
            return null;
        }

        var root = new TreeNode(nums[maxIndex]);

        root.left = build(nums, left, maxIndex - 1);
        root.right = build(nums, maxIndex + 1, right);
        return root;
    }
}
