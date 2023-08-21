package com.liquor.leetcode.tree;

import com.liquor.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 层次打印二叉树
 */
public class HierarchicalPrintTree {

    public final List<Integer> list = new ArrayList<>();

    public void print(TreeNode treeNode) {

        final LinkedList<TreeNode> queue = new LinkedList<>();

        if (Objects.nonNull(treeNode)) {
            queue.push(treeNode);
        }
        //O(N)
        while (!queue.isEmpty()) {
            final TreeNode poll = queue.poll();
            list.add(poll.val);
            if (Objects.nonNull(poll.left)) {
                queue.add(poll.left);
            }
            if (Objects.nonNull(poll.right)) {
                queue.add(poll.right);
            }
        }
    }


}
