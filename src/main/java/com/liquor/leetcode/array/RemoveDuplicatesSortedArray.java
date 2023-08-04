package com.liquor.leetcode.array;

/**
 * 删除排序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 双指针法
 * 返回的是新数组的长度，所以不需要真的删除数组中的元素，只需要把不重复的元素放到数组前面就行了
 */
public class RemoveDuplicatesSortedArray {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }

    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int fast = 0;
        int slow = 0;

        while (fast < nums.length) {
            // 如果是不重复的数字，
            if (nums[fast] != nums[slow]) {
                // slow 前进一步
                slow++;
                //就把这个数字放到慢指针的位置
                nums[slow] = nums[fast];
            }
            fast++;
        }


        return slow + 1;
    }
}
