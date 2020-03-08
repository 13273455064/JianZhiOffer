package com.liquor.offer.no1to10;

/**
 * 剑指offer第6题
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 *
 * 前序遍历，第一个数肯定是根节点
 * 在中序遍历里面找到前序遍历的第一个数，此数左边的属于根节点的左侧孩子，右边的属于根节点的右侧孩子，剩下的递归即可
 *
 */
public class No4 {
    /**
     * 先搞一个内部类，定义树的节点
     */
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    private TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || in.length <= 0 || pre.length != in.length) {
            throw new RuntimeException("数组不符合规范！");
        }
        return construct(pre,in,0,pre.length-1,0,in.length-1);
    }


    private static void preOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val);
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    private static void inOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.left);
        System.out.print(node.val);
        inOrderTraverse(node.right);
    }



    /**
     * 由前序遍历和中序遍历的到根节点
     * @param pre 前序遍历的数组
     * @param in  中序遍历的数组
     * @param pstart 前序遍历开始位置
     * @param pend   前序遍历的结束为止
     * @param istart 中序遍历的开始位置
     * @param iend   中序遍历的结束位置
     */
    public TreeNode construct(int[] pre, int[] in, int pstart, int pend, int istart, int iend){

        //前序遍历，第一个数是根节点

        if (pstart>pend || istart>iend){
            return null;
        }
        TreeNode node = new TreeNode(pre[pstart]);
        for (int i = istart; i <= iend; i++) {
            if (in[i] == pre[pstart]){
                //左子树的数量，就是i减去中序遍历起始位置坐标
                int leftTreeSize = i-istart;
                node.left = construct(pre,in,pstart+1,pstart+leftTreeSize,istart,i-1);
                node.right = construct(pre,in,pstart+leftTreeSize+1,pend,i+1,iend);
            }
        }
        return node;
    }

    /**
     * 第一遍  i=2  istart=0 psetart =0
     * @param args
     */
    public static void main(String[] args) {
        int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
        int[] in  = { 4, 7, 2, 1, 5, 3, 8, 6 };
        No4 demo = new No4();
        TreeNode root = demo.reConstructBinaryTree(pre, in);
        preOrderTraverse(root);
        System.out.println();
        inOrderTraverse(root);

    }

}
