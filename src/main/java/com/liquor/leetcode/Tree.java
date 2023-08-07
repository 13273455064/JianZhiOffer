package com.liquor.leetcode;

import java.util.LinkedList;
import java.util.Objects;

public class Tree {


    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public static void main(String[] args) {

    }

    public void print(TreeNode treeNode) {

        final LinkedList<TreeNode> queue = new LinkedList<>();

        if (Objects.nonNull(treeNode)) {
            queue.push(treeNode);
        }
        //O(N)
        while (!queue.isEmpty()) {
            final TreeNode poll = queue.poll();
            System.out.println(poll.val);
            if (Objects.nonNull(poll.left)) {
                queue.add(poll.left);
            }
            if (Objects.nonNull(poll.right)) {
                queue.add(poll.right);
            }
        }
    }


}
