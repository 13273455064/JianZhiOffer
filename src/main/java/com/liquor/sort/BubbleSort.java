package com.liquor.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,3,6,7,5,2,1,9,10};

        final int length = arr.length;

        int temp;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1; j++) {

                if (arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
