package com.liquor.leetcode.tree;

import com.liquor.common.TreeNode;
import com.liquor.mock.MockTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConstructTreeTest {

    @Test
    void buildTree() {
        TreeNode expect = MockTree.mockCommonTree.get();
        ConstructTree constructTree = new ConstructTree();
        var preorder = new int[]{3, 9, 20, 15, 7};
        var inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode result = constructTree.buildTree(preorder, inorder);
        Assertions.assertEquals(expect, result);
    }

    @Test
    void buildTree2() {
        var root = new TreeNode(1);
        var node2 = new TreeNode(2);
        var node3 = new TreeNode(3);
        root.left = node2;
        node2.left = node3;
        var constructTree = new ConstructTree();
        var preorder = new int[]{1, 2, 3};
        var inorder = new int[]{3, 2, 1};
        TreeNode result = constructTree.buildTree(preorder, inorder);
        Assertions.assertEquals(root, result);

    }

}