package com.liquor.jianzhioffer.no31to40;

import java.util.Stack;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * 先得理解啥是公共节点，不是说节点的值相等就是公共节点，而是两个两个链表交叉的那个节点，该节点往后的子链表在两个链表中是相同的。
 * 首先想到的就是暴力对比，对于链表a的每一个节点，都去链表b遍历对比，判断后面的节点是否相等，时间复杂度是O(m*n),代码就不写了
 *
 * 1. 使用两个栈，先把两个链表入栈，然后再出栈，直到找到第一个不相同的节点，时间复杂度O(m+n),空间复杂度O(m+n)
 * 2. 利用两个链表的长度差，让比较长的那个先走几步，(需要确定，先走的这几步里的节点，肯定不是第一个公共节点)，后面两个长度相同的链表
 *    再同时去判断，直到找到第一个公共节点,时间复杂度O(m+n)
 * 3. 把两个链表拼接起来，第一个是a在前b在后，第二个相反，用两个指针去遍历两个拼起来的链表，最终一定会到达null或者第一个公共节点，
 *    时间复杂度O(m+n)，胜在代码简洁，但是不太好懂
 *
 * @author zzc on 2020.1.2
 */
public class No38 {


    /**
     * 使用两个指针，
     */
    public ListNode FindFirstCommonNode3(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null){
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while (p1 != p2){
            p1 = p1 ==null ? pHead2 : p1.next;
            p2 = p2 ==null ? pHead1 : p2.next;
        }
        return p1;
    }

    /**
     * 利用链表的长度
     */
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null){
            return null;
        }
        int len1 = getLen(pHead1);
        int len2 = getLen(pHead2);
        //让比较长的那个链表先走几步，多出来的那些节点必定不是第一个公共节点
        if (len1 > len2){
            for (int i=0;i<(len1-len2);i++){
                pHead1 = pHead1.next;
            }
        }else if (len1<len2){
            for (int i=0;i<(len2-len1);i++){
                pHead2 = pHead2.next;
            }
        }
        //到这里肯定成了一般长的链表，只需要判断每一个节点是否相同即可
        while (pHead1!=null && pHead2!=null){
            if (pHead1.val != pHead2.val){
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }else{
                break;
            }
        }
        return pHead1;
    }

    private int getLen(ListNode head) {
        int len = 0;
        while (head!=null){
            len+=1;
            head = head.next;
        }
        return len;
    }

    /**
     * 使用栈
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1==null || pHead2 == null){
            return null;
        }

        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        //两个链表入栈
        while (pHead1!=null){
            stack1.add(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2!=null){
            stack2.add(pHead2);
            pHead2 = pHead2.next;
        }
        ListNode last = null;

        while (!stack1.isEmpty() && !stack2.isEmpty()){
            //当两个栈都不为空时，比较栈顶元素是否相同
            ListNode h1 = stack1.pop();
            ListNode h2 = stack2.pop();
            if (h1.val == h2.val){
                last = h1;
            }else {
                break;
            }
        }

        return last;
    }


    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
