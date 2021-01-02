package com.liquor.jianzhioffer.no41to50;

import java.util.LinkedList;

/**
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....
 * 直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 *
 * 如果没有小朋友，请返回-1
 *
 * 其实这就是一个约瑟夫环的问题，但是本数学渣渣表示并不会，有两种解法，分别为链表模拟和数学推导
 *
 * 链表模拟就比较简单了，使用一个链表，每一次就从里面移除数据，关键在怎么知道删除元素的位置,时间复杂度为O(mn)，空间复杂度为O(n)。
 *
 *
 * 数学推导：https://segmentfault.com/a/1190000015932138
 * @author zzc on 2020.1.13
 */
public class No48 {
    public int LastRemaining_Solution(int n, int m) {
        if (n<1 || m<1){
            return -1;
        }
        LinkedList<Integer> link = new LinkedList<>();
        for (int i=0;i<n;i++){
            link.add(i);
        }
        int remove=0;
        while (link.size()>1){
            //通过对链表的长度取余实现循环，需要对LinkedList比较熟悉
            remove = (remove+m-1)%link.size();
            link.remove(remove);
        }
        return link.getFirst();
    }

    public int LastRemaining_Solution2(int n, int m) {
        if (n<1 || m<1){
            return -1;
        }
        int result = 0;
        for (int i=2;i<=n;i++){
            //搞不懂为啥是i不是n
            result = (result+m)%i;
        }
        return result;
    }
}
