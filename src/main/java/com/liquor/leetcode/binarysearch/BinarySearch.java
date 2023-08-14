package com.liquor.leetcode.binarysearch;

/**
 * 二分查找
 * <p>
 * https://leetcode.cn/problems/binary-search/
 */
public class BinarySearch {

    public static void main(String[] args) {
        var nums = new int[]{-1, 0, 3, 5, 9, 12};
        var target = 2;
        System.out.println(search(nums, target));
    }

    static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        return -1;
    }
}
