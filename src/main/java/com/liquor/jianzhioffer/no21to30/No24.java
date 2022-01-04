package com.liquor.jianzhioffer.no21to30;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Level;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * <p>
 * 这题讲道理比较简单，就是单纯的二叉树层次遍历，但是我太菜了，不会二叉树的层次遍历，先去学习了一波
 * 借助一个队列。先将二叉树根节点入队，然后开启while循环，将每一个队头的元素出队放到返回序列里面，然后把它的左右子节点入队，当队列空是结束循环
 * <p>
 * 因为需要按层次遍历节点，所以我们可以使用队列先进先出的特点来存储每层节点的值
 * 每取出一个节点就将该节点的左右节点存入队列当中
 *
 * @author zzc
 */
public class No24 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        //linkedList实现了Quere接口，所以直接用它就好
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() != 0) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            result.add(node.val);
        }
        return result;
    }

    public static void main(String[] args) {
        final TreeNode node3 = new TreeNode(3);
        final TreeNode node9 = new TreeNode(9);
        final TreeNode node20 = new TreeNode(20);
        final TreeNode node15 = new TreeNode(15);
        final TreeNode node7 = new TreeNode(7);
        final TreeNode node2 = new TreeNode(2);
        final TreeNode node1 = new TreeNode(1);

        node3.left = node9;
        node3.right = node20;
        node9.left = node1;
        node9.right = node2;
        node20.left = node15;
        node20.right = node7;
        final List<List<Integer>> levelOrder = levelOrder(node3);
        System.out.println(levelOrder);
        System.out.println(levelOrder2(node3));
    }

    /**
     * BFS 分层打印二叉树，但是每一层要打印在一起
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        final ArrayList<ArrayList<Integer>> objects = new ArrayList<>(new ArrayList<>());
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            final int size = queue.size();
            for (int i = size; i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }


    /**
     * BFS 分层打印二叉树，但是每一层要打印在一起,并且奇数行从左往右偶数行从右往左
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(new ArrayList<>());
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (res.size() % 2 == 0) {
                    tmp.addLast(node.val);
                } else {
                    tmp.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }

}
