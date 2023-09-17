package com.liquor.leetcode.array;

/**
 * 除自身以外数组的乘积
 * <p>
 * https://leetcode.cn/problems/product-of-array-except-self/description/
 */
public class ProductOfArrayExceptSelf {


    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        var left = new int[nums.length];
        var right = new int[nums.length];


        left[0] = 1;
        right[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }

        var result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }

}
