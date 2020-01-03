package com.liquor.offer.no31to40;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * 排序的数组，用二分查找,但是涉及到需要在每一次定位二分点时向前和向后查找，在某些情况下时间复杂度会达到O(n)
 * 因此改进二分查找,把可能出现的情况进行分类讨论，对于二分查找的中间数字，会有三种情况
 * arr[mid] == k
 * arr[mid] > k
 * arr[mid] < k
 * 对于大于和小于，和二分查找的做法一致，而对于等于，又分为四种情况
 * arr[mid-1] == k，说明第一个k在前半段，在前半段继续二分法查找
 * arr[mid-1]！= k，说明mid位置是第一个k
 * arr[mid+1] == k，说明最后一个k在后半段，在后半段继续二分查找
 * arr[mid+1]！= k，说明mid位置是最后一个k
 *
 * @author zzc on 2020.1.3
 */
public class No39 {

    public int GetNumberOfK(int [] array , int k) {

        if (array.length == 0){
            return 0;
        }

        int first = getFirst(array,k,0,array.length-1);
        int end = getEnd(array,k,0,array.length-1);

        if (first==-1 || end==-1){
            return 0;
        }
        return end-first+1;
    }

    private int getFirst(int[] array, int k, int start, int end) {
        if (start > end){
            return -1;
        }
        int mid = (start + end) >>1;

        //需要注意数组下标边界值
        if (array[mid] < k){
            return getFirst(array,k,mid+1,end);
        }else if (array[mid] > k){
            return getFirst(array,k,start,mid-1);
        }else if (mid-1>=0 && array[mid-1] == k){
            return getFirst(array,k,start,mid-1);
        }else {
            return mid;
        }
    }

    private int getEnd(int[] array, int k, int start, int end) {
        if (start > end){
            return -1;
        }
        int mid = (start + end) >> 1;
        if (array[mid] < k){
            return getEnd(array,k,mid+1,end);
        }else if (array[mid] > k){
            return getEnd(array,k,start,mid-1);
        }else if (mid+1<array.length && array[mid+1] == k){
            return getEnd(array,k,mid+1,end);
        } else {
            return mid;
        }
    }


}
