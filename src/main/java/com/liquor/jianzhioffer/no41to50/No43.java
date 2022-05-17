package com.liquor.jianzhioffer.no41to50;

import java.util.ArrayList;

/**
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * <p>
 * 使用两个指针，表示一个数据窗口，因为是连续正数，可以看成公差为1的等差数列
 * 只要计算等差数列的和，然后与输入S进行比较
 * 如果大于S,左边指针右移，相当于缩小等差数列的和
 * 如果小于S,右边指针右移，相当于增大等差数列的和
 * 如果恰好等于S,说明找到了一个序列，把这个数列记录下来，之后右边指针右移，为啥是右边指针右移呢，其实那个指针移动都一样，左边先移，那下一步就得右边移
 * <p>
 * 需要注意的是，并不需要用数据窗口把数组遍历完全
 * 因为当左边指针到了S的一半之后，无论如何再往右移动，等差数列的和恒大与S
 *
 * @author zzc on 2020.1.8
 */
public class No43 {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> sequenceList = new ArrayList<>();
        if (sum <= 0) {
            return sequenceList;
        }
        int left = 1;
        int right = 2;
        int s = left + right;
        while (left <= sum / 2) {
            //等差数列求和公式：((首项+末项)*项数)/2
            //其实以为是等差数列，可以不用每次都计算的，
            //int s = ((left+right)*(right-left+1))/2;
            if (s > sum) {
                //左边指针移位，先计算再移位
                s -= left;
                left++;

            } else if (s < sum) {
                //右边指针移位，先移位再计算
                right++;
                s += right;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    list.add(i);
                }
                sequenceList.add(list);
                right++;
                s += right;
            }
        }
        return sequenceList;
    }


}
