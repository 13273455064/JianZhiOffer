package com.liquor.leetcode.tree;

import com.liquor.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 * <p>
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        var map = new HashMap<Integer, Integer>(inorder.length);
        for (int i = 0; i <= inorder.length - 1; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, map, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, Map<Integer, Integer> map, int pStart, int pEnd, int inStart, int inEnd) {
        if (pStart > pEnd || inStart > inEnd) {
            return null;
        }
        // 前序遍历的第一个就是根节点
        var rootVal = preorder[pStart];

        var root = new TreeNode(rootVal);

        // 找到根节点在中序遍历中的位置
        var rootIndex = map.get(rootVal);

        //左子树的长度
        var leftSize = rootIndex - inStart;

        root.left = build(preorder, map, pStart + 1, pStart + leftSize, inStart, rootIndex - 1);
        root.right = build(preorder, map, pStart + leftSize + 1, pEnd, rootIndex + 1, inEnd);

        return root;
    }
}
