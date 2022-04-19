package com.liquor.sort;

import java.util.Arrays;

/**
 * 归并排序
 * https://www.cnblogs.com/tuyang1129/p/12857821.html
 */
public class MergeSort {


    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 5, 8, 32, 4, 100, 7, 6, 11};
        final int[] newArr = new int[arr.length];
        int start = 0;
        int end = arr.length - 1;
        mergeSort(arr, start, end, newArr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int start, int end, int[] newArr) {
        if (start >= end) {
            return;
        }
        //拆分
        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid, newArr);
        mergeSort(arr, mid + 1, end, newArr);
        merge1(arr, start, mid, end, newArr);
    }

    /**
     * 合并
     */
    private static void merge1(int[] arr, int start, int mid, int end, int[] newArr) {


        int p1 = start;//左数组的指针
        int p2 = mid + 1;//右数组的指针
        int i = 0;//新数组的指针

        while (p1 <= mid && p2 <= end) {
            if (arr[p1] <= arr[p2]) {
                newArr[i++] = arr[p1++];
            } else {
                newArr[i++] = arr[p2++];
            }
        }
        while (p1 <= mid) {
            newArr[i++] = arr[p1++];
        }
        while (p2 <= end) {
            newArr[i++] = arr[p2++];
        }
        i = 0;
        while (start <= end) {
            arr[start++] = newArr[i++];
        }
    }
}
