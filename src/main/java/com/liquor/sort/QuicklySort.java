package com.liquor.sort;

import java.util.Arrays;

//https://zhuanlan.zhihu.com/p/35946897
public class QuicklySort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 3, 6,7,2,9,5,23,32,12,555,123,32,765};
        final int length = arr.length;
        sort(arr, 0, length - 1);
        System.out.println(Arrays.toString(arr));

    }

    private static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int tmp = arr[start];
            int left = start;
            int right = end;

            while (left < right) {

                while (left < right && arr[right] >= tmp) {
                    right--;
                }

                if (left < right) {
                    arr[left] = arr[right];
                    left++;
                }


                while (left < right && arr[left] < tmp) {
                    left++;
                }

                if (left < right) {
                    arr[right] = arr[left];
                    right--;
                }

            }
            arr[left] = tmp;
            sort(arr, start, left - 1);
            sort(arr, left + 1, end);
        }
    }
}
