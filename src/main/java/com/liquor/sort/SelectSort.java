package com.liquor.sort;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,5,4,7,6,11};
        final int length = arr.length;
        int temp;
        for (int i = 0; i < length - 1; i++) {
           int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                 if (arr[j] < arr[minIndex]) {
                     minIndex = j;
                 }
                 if (j == length - 1) {
                     temp = arr[minIndex];
                     arr[minIndex] = arr[i];
                     arr[i] = temp;
                 }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
