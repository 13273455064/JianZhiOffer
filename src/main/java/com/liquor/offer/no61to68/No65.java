package com.liquor.offer.no61to68;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 *                                          {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 *
 *  这道题乍一看使用我的暴力搜索法能实现，但是时间复杂度太高了，不足以拿到offer，需要找到一个降低时间复杂度的方法
 *  网上说使用一个双端队列，但是菜鸡的我并不知道那是个啥，参考   https://blog.csdn.net/u011240877/article/details/52865173
 *  简单来说，双端队列就是两头都能入队，两头都能出队的一个队列
 *  具体思路就是使用双端队列存储可能是最大值的数的坐标，队头始终存那个最大的数
 *  从头开始扫描数组，
 *  首先，所有在没有查看后面数字的情况下，任何一个节点都有可能成为某个状态的滑动窗口的最大值，因此，数组中任何一个元素的下标都会入队。
 *  关键在于出队，以下两种情况下，该下标对应的数字不会是窗口的最大值需要出队：
 *  (1)该下标已经在窗口之外，比如窗口长度为3，下标5入队，那么最大值只可能在下标3,4,5中出现，队列中如果有下标2则需要出队；
 *  (2)后一个元素大于前面的元素，那么前面的元素出对，比如目前队列中有下标3、4，data[3] = 50,data[4]=40，下标5入队，但data[5] = 70，则队列中的3，4都需要出队。
 *
 *  滑动窗口的最大值总是保存在队列首部，队列里面的数据总是从大到小排列。当遇到比当前滑动窗口最大值更大的值时，则将队列清空，并将新的最大值插入到队列中。
 *  如果遇到的值比当前最大值小，则直接插入到队列尾部。每次移动的时候需要判断当前的最大值是否在有效范围，如果不在，则需要将其从队列中删除。
 *  由于每个元素最多进队和出队各一次，因此该算法时间复杂度为O(N)
 * 　
 * @author zzc on 2020.2.1
 */
public class No65 {

    /**
     * 暴力搜索法，时间复杂度 O(nk)，k为窗口的大小
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num.length==0 || size<=0 || size>num.length){
            return list;
        }
        int left = 0;
        int right = 0;
        int max1 = 0;
        //右边指针先走，顺便找一下走过的数中的最大值,切记考虑 size>num.length的情况
        for (int i=0;i<size && i<num.length;i++){
            right++;
            if (i==0){
                max1 = num[i];
            }
            int curr = num[i];
            if (curr>max1){
                max1 = curr;
            }
        }
        list.add(max1);
        while (right<num.length){
            left++;
            right++;
            int max2 = 0;
            for (int i=left;i<right;i++){
                if (num[i] > max2){
                    max2 = num[i];
                }
            }
            list.add(max2);
        }
        return list;
    }

    /**
     * 使用双端队列的解法，时间复杂度O(n)
     */
    public ArrayList<Integer> maxInWindows2(int [] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num.length==0 || size<=0 || size>num.length){
            return list;
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for(int i=0;i<size-1;i++){
            while (!deque.isEmpty()&&num[i]>=num[deque.getLast()])
                deque.removeLast();
            deque.addLast(i);
        }
        for(int i=size-1;i<num.length;i++){
            while (!deque.isEmpty()&&i-deque.getFirst()+1>size)
                deque.removeFirst();
            while (!deque.isEmpty()&&num[deque.getLast()]<=num[i])
                deque.removeLast();
            deque.addLast(i);
            list.add(num[deque.getFirst()]);
        }
        return list;
    }
}
