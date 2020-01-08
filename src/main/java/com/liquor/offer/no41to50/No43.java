package com.liquor.offer.no41to50;

import java.util.ArrayList;

/**
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 *
 *
 * @author  zzc on 2020.1.8
 */
public class No43 {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > sequenceList = new ArrayList<>();
        if (sum<=0){
            return sequenceList;
        }
        int left = 1;
        int right = 2;
        while (left<right && right<sum/2){
            //等差数列求和公式：((首项+末项)*项数)/2
            int s = ((left+right)*(right-left+1))/2;
            if (s>sum){

            }
        }

        return null;
    }




}
