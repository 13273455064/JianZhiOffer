package com.liquor.offer.no61to68;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 * 乍一看，我还以为这不就是原来那个二叉树层次遍历的题么，当我自习读了三遍题目之后，才发现其中的区别
 * 之前那个是层次打印就完事，但是这个要求的是需要一层一层地打印，我们在之前的时候并不知道每一层有多少个节点，
 * 但是现在必须根据每一层的节点的数量来打印，如何确定每一层的节点的数量是本题的精髓所在
 *
 *
 * zzc on 2020.1.30
 */
public class No61 {

    public ArrayList<ArrayList<Integer>> PrintFromTopToBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (root==null){
            return lists;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.offer(root);
        int start = 0;
        //因为一开始只有一个根节点
        int end = 1;
        while (!queue.isEmpty()){
            //取出队首元素
            TreeNode node = queue.poll();
            if (node.left!=null){
                queue.offer(node.left);
            }
            if (node.right!=null){
                queue.offer(node.right);
            }
            list.add(node.val);
            start++;
            //当每一行搞完时，说明上一行的节点全部干掉了，此时队列中全部是下一行的节点，再从下一行开始
            if (start == end){
                lists.add(list);
                start=0;
                end = queue.size();
                list = new ArrayList<>();
            }
        }
        return lists;
    }


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
