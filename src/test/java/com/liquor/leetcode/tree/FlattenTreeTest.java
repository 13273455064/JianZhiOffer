package com.liquor.leetcode.tree;

import com.liquor.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class FlattenTreeTest {

    @Test
    void flatten() {
        // 构造一颗二叉树
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
        new FlattenTree().flatten(root);

        var list = List.of(1, 2, 3, 4, 5, 6);
        var result = new ArrayList<Integer>();
        result.add(root.val);
        while (root.right != null) {
            Assertions.assertNull(root.left);
            result.add(root.right.val);
            root = root.right;
        }
        Assertions.assertEquals(result, list);
    }

}