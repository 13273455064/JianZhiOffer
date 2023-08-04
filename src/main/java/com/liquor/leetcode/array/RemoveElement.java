package com.liquor.leetcode.array;

/**
 * 移除元素
 * https://leetcode-cn.com/problems/remove-element/
 * 双指针法
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        var val = 3;
        var i = remove(nums, val);
        System.out.println(i);

    }

    static int remove(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
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

        return slow;
    }
}
