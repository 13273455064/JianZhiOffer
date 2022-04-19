package com.liquor.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 堆排序
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 5, 8, 32, 4, 100, 7, 6, 11};

        heapSort(arr);
        //heapSort(arr, new PriorityQueue<>(arr.length));

        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr, PriorityQueue<Integer> priorityQueue) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int a : arr) {
            priorityQueue.offer(a);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = priorityQueue.poll();
        }

    }

    private static void heapSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            buildHeap(arr, arr.length - i);
            swap(arr, 0, (arr.length - 1) - i);
        }
    }

    /**
     * 建堆
     */
    private static void buildHeap(int[] arr, int size) {
        // 从数组的尾部开始，直到第一个元素
        for (int i = size - 1; i >= 0; i--) {
            adjustHeap(arr, i, size);
        }
    }


    /**
     * 大顶堆，堆调整
     *
     * @param arr     表示堆的数组
     * @param current 当前节点
     * @param size    堆的大小
     */
    private static void adjustHeap(int[] arr, int current, int size) {
        if (current < size) {
            //左子节点
            int left = current * 2 + 1;
            //右子节点
            int right = left + 1;

            int max = current;

            if (left < size && arr[max] < arr[left]) {
                max = left;
            }
            if (right < size && arr[max] < arr[right]) {
                max = right;
            }
            if (max != current) {
                swap(arr, max, current);
                adjustHeap(arr, max, size);
            }
        }
    }

    private static void swap(int[] arr, int max, int current) {
        int temp = arr[max];
        arr[max] = arr[current];
        arr[current] = temp;
    }


}
