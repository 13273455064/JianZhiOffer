package com.liquor.leetcode.tree;

import com.liquor.mock.MockTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LowestCommonAncestorTest {

    @Test
    void lowestCommonAncestor() {
        var tree = MockTree.mockCommonTree.get();
        var result = new LowestCommonAncestor().lowestCommonAncestor(tree, tree.left, tree.right);
        Assertions.assertEquals(result, tree);

    }
}