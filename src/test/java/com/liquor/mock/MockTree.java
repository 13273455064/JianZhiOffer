package com.liquor.mock;

import com.liquor.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Function;
import java.util.function.Supplier;

public class MockTree {

    public static Supplier<TreeNode> mockFullTree = () -> {
        var root = new TreeNode(1);
        var node2 = new TreeNode(2);
        var node3 = new TreeNode(3);
        var node4 = new TreeNode(4);
        var node5 = new TreeNode(5);
        var node6 = new TreeNode(6);
        root.left = node2;
        root.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;
        return root;
    };

    public static Supplier<TreeNode> mockCommonTree = () -> {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode leftLeft = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);
        root.left = left;
        root.right = right;
        right.left = leftLeft;
        right.right = rightRight;
        return root;
    };


    /**
     * 通过二叉树层次遍历的结果构造二叉树
     */
    public static Function<List<List<Integer>>, TreeNode> mockTreeWithLine = (lines) -> {

        if (lines == null || lines.isEmpty() || lines.get(0).isEmpty()) {
            return null;
        }

        TreeNode root = new TreeNode(lines.get(0).get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 1;
        while (!queue.isEmpty() && level < lines.size()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                List<Integer> values = lines.get(level);
                if (i < values.size()) {
                    if (values.get(i) != null) {
                        current.left = new TreeNode(values.get(i));
                        queue.offer(current.left);
                    }
                }
                if (++i < values.size()) {
                    if (values.get(i) != null) {
                        current.right = new TreeNode(values.get(i));
                        queue.offer(current.right);
                    }
                }
            }
            level++;
        }
        return root;
    };
}
