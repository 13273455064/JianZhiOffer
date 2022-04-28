package com.liquor.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 3, 6, 7, 5, 2, 1, 9, 10};

        final int length = arr.length;

        int temp;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i; j < length - 1; j++) {

                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
