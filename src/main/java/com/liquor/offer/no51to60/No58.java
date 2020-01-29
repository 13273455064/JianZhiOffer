package com.liquor.offer.no51to60;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * 我的思路就是搞两个指针，然后向后遍历，相同的就删除。是我没有理解题意，人家说 重复的结点不保留
 * ，于是我第一次的解法不正确，只需要稍加改造即可，
 * 另p1指向当前确定不重复的节点，而p2向后面扫描，最后把p1的next指向p2的next(即下一个不重复的节点)
 *
 * @author zzc on 2020.1.29
 */
public class No58 {

    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead==null || pHead.next==null){
            return pHead;
        }
        ListNode head = new ListNode(0);
        head.next = pHead;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2!=null){
            if (p2.next!=null && p2.next.val==p2.val){
                while (p2.next!=null && p2.next.val==p2.val){
                    p2 = p2.next;
                }
                p1.next = p2.next;
                p2 = p2.next;

            }else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(1);
        ListNode p3 = new ListNode(1);
        ListNode p4 = new ListNode(1);
        ListNode p5 = new ListNode(1);
        ListNode p6 = new ListNode(1);
        ListNode p7 = new ListNode(2);
        p1.next=p2;
        p2.next=p3;
        p3.next=p4;
        p4.next=p5;
        p5.next=p6;
        p6.next=p7;
        ListNode head = deleteDuplication(p1);
        while (head!=null){
            System.out.print(head.val);
            System.out.print(" ");
            head = head.next;
        }

    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
