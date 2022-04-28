package com.liquor.sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 5, 8, 32, 4, 100, 7, 6, 11};
        final int length = arr.length;

        for (int i = 1; i < length; i++) {

            int temp = arr[i];

            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
