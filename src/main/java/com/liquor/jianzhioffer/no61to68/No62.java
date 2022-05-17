package com.liquor.jianzhioffer.no61to68;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * <p>
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。
 * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 * <p>
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 * <p>
 * 一般情况下，需要采用前/后序遍历和中序遍历才能确定一个二叉树，
 * 但是其实可以只采用前序遍历（从根结点开始），将空结点(null)输出为一个特殊符号（如“#”），就可以确定一个二叉树了。
 * <p>
 * 将字符串反序列化为二叉树，也使用前序遍历，遇见一个新数字(或者#)就建立一个新结点
 * 最令我疑惑的是，别人答案里面的index是干啥的？
 *
 * @author zzc on 2020.1.30
 */
public class No62 {

    int index = -1;

    String Serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        Serialize1(root, sb);
        return sb.toString();
    }

    private void Serialize1(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append("#!");
            return;
        }
        sb.append(root.val).append("!");
        Serialize1(root.left, sb);
        Serialize1(root.right, sb);
    }

    TreeNode Deserialize(String str) {
        if (str.length() == 0) {
            return null;
        }
        String[] strs = str.split("!");
        return Deserialize2(strs);
    }

    private TreeNode Deserialize2(String[] strs) {
        //index的作用就是每搞一个节点，向后移动一个索引。需要注意就算是空的节点也要移动
        index++;
        if (!strs[index].equals("#")) {
            TreeNode root = new TreeNode(0);
            root.val = Integer.parseInt(strs[index]);
            root.left = Deserialize2(strs);
            root.right = Deserialize2(strs);
            return root;
        }
        return null;
    }


    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
