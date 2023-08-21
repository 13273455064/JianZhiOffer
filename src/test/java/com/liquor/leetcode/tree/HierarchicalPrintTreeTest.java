package com.liquor.leetcode.tree;

import com.liquor.mock.MockTree;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HierarchicalPrintTreeTest {

    @Test
    void print() {
        // 构造一颗二叉树
        var root = MockTree.mockFullTree.get();
        var test = new HierarchicalPrintTree();
        test.print(root);
        var result = test.list;
        assertEquals(result, List.of(1, 2, 5, 3, 4, 6));
    }
}