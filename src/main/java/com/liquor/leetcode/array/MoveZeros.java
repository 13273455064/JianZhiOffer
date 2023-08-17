package com.liquor.leetcode.array;

/**
 * 移动零
 * https://leetcode-cn.com/problems/move-zeroes/
 * 双指针法
 */
public class MoveZeros {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 0, 1, 2, 2, 3, 3, 4};
        remove(nums, 0);
        //move(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    /**
     * 使用左右指针移动元素的思路
     * 但是这种方法无法保持非 0 元素的顺序
     */
    static void move(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            // 如果左指针的元素不是 0 ，就向右移动左指针
            if (nums[left] != 0) {
                left++;
                continue;
            }

            // 如果右指针的元素恰好是0，就向左移动右指针
            if (nums[right] == 0) {
                left++;
                continue;
            }

            if (nums[left] == 0) {
                int swap = nums[right];
                nums[right] = nums[left];
                nums[left] = swap;
                left++;
                right--;
            }
        }
    }

    /**
     * 使用移除元素的思路
     */
    static void remove(int[] nums, int val) {
        if (nums.length == 0) {
            return;
        }

        int fast = 0;
        int slow = 0;

        while (fast < nums.length) {
            // 如果是不等于 val 的数字，
            if (nums[fast] != val) {
                //就把这个数字放到慢指针的位置
                nums[slow] = nums[fast];
                // slow 前进一步
                slow++;
            }
            fast++;
        }

        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
