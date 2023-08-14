package com.liquor.leetcode.binarysearch;

import java.util.Arrays;

/**
 * 寻找有序数组中数字的左右边界
 * <p>
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 */
public class FirstLastPosition {

    public static void main(String[] args) {
        var nums = new int[]{1};
        var target = 1;
        System.out.println(Arrays.toString(searchRange(nums, target)));

    }

    static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int[] result = new int[]{-1, -1};
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                // 收缩右指针，寻找左边界
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        if (nums[left] == target) {
            result[0] = left;
        }

        left = 0;
        right = nums.length;


        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                // 收缩左指针，寻找右边界
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }

        if (nums[right - 1] == target) {
            result[1] = right - 1;
        }
        return result;
    }
}
