package com.liquor.jianzhioffer.no61to68;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8） 中，按结点数值大小顺序第三小结点的值为4。
 *
 * 做这道题，只需要记住一句话， 二叉搜索树的中序遍历顺序就是从小到大的排序顺序x`
 *
 *
 * @author zzc on 2020.1.31
 */
public class No63 {

    int index = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot!=null){
            //先找到最左侧，也就是最小的节点
            TreeNode node = KthNode(pRoot.left,k);
            if (node!=null){
                //这里实际上是把最左侧的节点返回给了第一层调用
                return node;
            }
            //从最小的开始寻找
            index++;
            if (k==index){
                //注意返回的是当前节点
                node = pRoot;
                return node;
            }
            node = KthNode(pRoot.right,k);
            return node;
        }
        return null;
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
