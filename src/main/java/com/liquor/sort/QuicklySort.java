package com.liquor.sort;

import java.util.Arrays;

//https://zhuanlan.zhihu.com/p/35946897
public class QuicklySort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 3, 2, 1};
        final int length = arr.length;
        final long start = System.currentTimeMillis();
        sort(arr, 0, length - 1);
        System.out.println(Arrays.toString(arr));
        System.out.println(System.currentTimeMillis() - start);

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
