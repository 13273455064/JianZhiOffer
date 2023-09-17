package com.liquor.leetcode.dp;

/**
 * 最大子数组和
 * <p>
 * https://leetcode.cn/problems/maximum-subarray/
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // dp 数组的每一个元素 dp[i] 表示 nums 中以 i 结尾的子数组的最大和
        var dp = new int[nums.length];

        //确定 bsse case
        dp[0] = nums[0];


        // 状态转移方程：dp[i] = max(dp[i-1] + nums[i], nums[i])
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        var max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
