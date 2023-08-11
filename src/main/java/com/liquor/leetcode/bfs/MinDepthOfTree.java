package com.liquor.leetcode.bfs;

import java.util.LinkedList;

import com.liquor.common.TreeNode;

import java.util.Queue;

/**
 * 二叉树的最小深度
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 * 
 * 使用BFS, 二叉树的层次遍历框架
 */
public class MinDepthOfTree {

    public static void main(String[] args) {
        // 构建一颗二叉树
        var root = new TreeNode(3);
        var left = new TreeNode(9);
        var right = new TreeNode(20);
        var rightLeft = new TreeNode(15);
        var rightRight = new TreeNode(7);
        root.left = left;
        root.right = right;
        right.left = rightLeft;
        right.right = rightRight;

        System.out.println(BFS(root));

    }

    /**
     * 二叉树的最小深度
     * 
     * @param root
     * @return
     */
    static int BFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // 根节点入队
        queue.offer(root);
        // 有根节点，深度至少为1
        int deep = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return deep;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

            }

            deep++;

        }

        return deep;
    }
}
