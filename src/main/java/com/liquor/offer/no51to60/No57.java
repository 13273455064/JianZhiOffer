package com.liquor.offer.no51to60;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * 解题的思路就是快慢指针的方法，时间复杂度 O(1),空间复杂度 O(1)
 *
 * 第一步：先寻找链表有没有环，使用两个指针，p1  p2 ,两个指针从头出发，p1一次走1步，p2一次走两步，当p1==p2的时候。就能证明有环，
 * 没有环的话直接返回null
 * 第二步：寻找环的节点数量
 * 第三步：两个指针再次从头出发，p1先走环的节点数量步，然后再和p2一块走，当p1==p2时，当前节点就是环的头结点
 *
 * @author zzc on 2020.1.28
 */
public class No57 {

    /**
     * 自己写的方法，代码有些繁琐，这里需要再改进
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        //头结点为空或者只有一个头结点的情况，一定要考虑到
        if (pHead==null || pHead.next==null){
            return null;
        }
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        ListNode huanNode = null;
        int count = 1;
        //确定是否有环并且寻找环节点
        while (p2!=null){
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1==p2 && p1!=null){
                huanNode = p1;
                break;
            }
        }
        if (p2==null){
            return null;
        }
        //寻找环的节点数量
        ListNode huanNodeNext = huanNode.next;
        while (huanNode!=huanNodeNext){
            count++;
            huanNodeNext = huanNodeNext.next;
        }
        //寻找环的头结点
        p1 = pHead;
        p2 = pHead;
        //p1先走环的节点数count步
        for (int i=0;i<count;i++){
            p1 = p1.next;
        }
        //p2再和p1同时走，当p1==p2时，当前节点就是环的初始节点
        while (p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }


    /**
     * 牛客上面的写法，方法一样，代码更简洁一点
     */
    public ListNode EntryNodeOfLoop2(ListNode pHead)
    {
        if(pHead==null||pHead.next==null)return null;
        ListNode p1=pHead;
        ListNode p2=pHead;
        while(p2!=null&&p2.next!=null)
        {
            p1=p1.next;
            p2=p2.next.next;
            if(p1==p2)
            {
                p1=pHead;
                while(p1!=p2)
                {
                    p1=p1.next;
                    p2=p2.next;
                }
                return p1;
            }
        }
        return null;
    }



    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
