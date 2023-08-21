package com.liquor.leetcode.tree;

import com.liquor.mock.MockTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class FlattenTreeTest {

    @Test
    void flatten() {
        // 构造一颗二叉树
        var root = MockTree.mockFullTree.get();
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