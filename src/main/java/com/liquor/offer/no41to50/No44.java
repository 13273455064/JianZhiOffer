package com.liquor.offer.no41to50;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 这题一看就是跟上一个和为S的连续正数序列有点关系，肯定还是同一种解法，甚至可以说是同一个题的两种变种
 *
 * 方法肯定还是两个指针，只不过两个指针不是成窗口的形式，而是一前一后向中间移动，是因为递增数组中和为S 的两个数
 * 如果一个数比较小，那么另一个数一定比较大，需要注意的是，递增排序数组，并不是连续的，不能看成等差数列
 * @author zzc on 2020.1.9
 */
public class No44 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array.length == 0){
            return result;
        }
        int l = 0;
        int r = array.length-1;
        while (l<r){
            int s = array[l]+array[r];
            if (s>sum){
                r--;
            }else if(s<sum){
                l++;
            }else{
                //最靠两边的乘积最小，所以找到的第一组数字就是乘积最小的
                result.add(0,array[l]);
                result.add(1,array[r]);
                break;
            }
        }
        return result;

    }

}
