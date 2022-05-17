package com.liquor.jianzhioffer.no51to60;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 * <p>
 * 讲道理，我感觉这道题跟那个层次遍历有点像，是否可以在层次遍历的基础上增加判断奇偶数层来打印出呢，
 * 所以我先去回顾了一波二叉树的层次遍历
 * <p>
 * 交换顺序打印，也可以想到使用栈的先进后出的特性，使用两个栈，来回倒替，
 * 先将第一层压入栈stack2
 * 然后将stack2中的元素依次出栈，并将其中的元素的左->右节点分别压入栈stack1
 * 同理，stack1的元素依次出栈，并将其中的元素的右->左节点依次压入栈stack2
 * 依次循环
 * <p>
 * https://segmentfault.com/a/1190000019699394
 *
 * @author zzc on 2020.1.29
 */
public class No60 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null) {
            return list;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(pRoot);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            ArrayList<Integer> list1 = new ArrayList<>();
            if (!stack1.isEmpty()) {
                //需要将stack1中的元素全部弹出，此时才是该层的所有节点
                while (!stack1.isEmpty()) {
                    TreeNode node = stack1.pop();
                    //弹出stack1的同时，将当前元素的左右节点压入stack2,需要注意判空
                    //需要特别强调是先左后右
                    if (node.left != null) {
                        stack2.push(node.left);
                    }
                    if (node.right != null) {
                        stack2.push(node.right);
                    }
                    list1.add(node.val);
                }
                list.add(list1);
            } else {
                while (!stack2.isEmpty()) {
                    TreeNode node = stack2.pop();
                    //弹出stack2的同时，将当前元素的右左节点压入stack1,需要注意判空
                    //需要特别强调是先右后左
                    if (node.right != null) {
                        stack1.push(node.right);
                    }
                    if (node.left != null) {
                        stack1.push(node.left);
                    }
                    list1.add(node.val);
                }
                list.add(list1);
            }
        }

        return list;
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
