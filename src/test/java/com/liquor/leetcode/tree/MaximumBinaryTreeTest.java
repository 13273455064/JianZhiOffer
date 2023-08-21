package com.liquor.leetcode.tree;

import com.liquor.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MaximumBinaryTreeTest {

    @Test
    void constructMaximumBinaryTree() {
        var nums = new int[]{3, 2, 1, 6, 0, 5};
        var test = new MaximumBinaryTree();
        TreeNode root = test.constructMaximumBinaryTree(nums);
        var print = new HierarchicalPrintTree();
        print.print(root);
        var result = print.list;
        Assertions.assertEquals(result, List.of(6, 3, 5, 2, 0, 1));
    }
}