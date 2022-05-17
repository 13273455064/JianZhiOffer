package com.liquor.jianzhioffer.no61to68;

import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 *
 * @author zzc on 2020.2.1
 */
public class No64 {

    //PriorityQueue默认实现的是小顶堆，传入比较器构造大顶堆
    //大顶堆，存储左半边元素
    PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
    //小顶堆，存储右半边元素，并且右半边元素都大于左半边
    PriorityQueue<Integer> right = new PriorityQueue<>();
    //记录第多少个数
    int count = 0;

    public void Insert(Integer num) {
        // 插入要保证两个堆存于平衡状态,所以偶数插入右边，奇数插入左边
        if ((count & 1) == 0) {
            //因为右半边元素都要大于左半边，但是新插入的元素不一定比左半边元素来的大，
            //因此需要先将元素插入左半边，然后利用左半边为大顶堆的特点，取出堆顶元素即为最大元素，此时插入右半边
            left.offer(num);
            right.offer(left.poll());

        } else {
            right.offer(num);
            left.offer(right.poll());
        }
        count++;
    }

    public Double GetMedian() {
        if ((count % 2) == 0) {
            //偶数取两个堆顶元素的平均数
            return (double) (left.peek() + right.peek()) / 2;
        } else {
            //奇数直接取小顶堆的堆顶
            return new Double(right.peek());
        }
    }

}
