package com.liquor.leetcode.array;


/**
 * 两数之和
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
 * 双指针，类似二分查找
 * 因为是有序数组
 */
public class TwoNumberSum {

    public static void main(String[] args) {
        var arr = new int[]{2, 7, 11, 15};
        var sum = 9;
        var addr = findSumArray(arr, sum);
        for (int j : addr) {
            System.out.println(j);
        }
    }

    static int[] findSumArray(int[] arr, int sum) {
        if (arr == null || arr.length == 0) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int add = arr[left] + arr[right];
            // 如果合为 num， 返回两个指针数据的数组
            if (add == sum) {
                return new int[]{left, right};
            }
            // 加起来大于 sum ， right 左移，缩小 add 的值
            if (add > sum) {
                right--;
            } else {
                left++;
            }
        }

        return new int[]{-1, -1};
    }
}
