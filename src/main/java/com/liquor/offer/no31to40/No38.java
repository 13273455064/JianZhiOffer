package com.liquor.offer.no31to40;

import java.util.Stack;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * 先得理解啥是公共节点，不是说节点的值相等就是公共节点，而是两个两个链表交叉的那个节点，该节点往后的子链表在两个链表中是相同的。
 * 首先想到的就是暴力对比，对于链表a的每一个节点，都去链表b遍历对比，判断后面的节点是否相等，时间复杂度是O(m*n),代码就不写了
 *
 * 使用两个栈，先把两个链表入栈，然后再出栈，直到找到第一个不相同的节点，时间复杂度O(m+n),空间复杂度O(m+n)
 *
 *
 */
public class No38 {

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
