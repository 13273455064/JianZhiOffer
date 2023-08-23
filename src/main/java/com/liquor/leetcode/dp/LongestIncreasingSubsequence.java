package com.liquor.leetcode.dp;


import java.util.Arrays;

/**
 * 最长递增子序列
 * <p>
 * https://leetcode.cn/problems/longest-increasing-subsequence/
 * <p>
 * 区分子序列和子串，子序列不一定连续
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        var res = Integer.MIN_VALUE;
        // dp 数组， dp[i]表示以数组第 i 个数字结尾的最长递增子序列
        var dpTable = new int[nums.length];
        // base case ,每一个元素的最长递增子序列长度肯定是1
        Arrays.fill(dpTable, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dpTable[i] = Math.max(dpTable[i], dpTable[j] + 1);
                }
            }
        }

        for (int j : dpTable) {
            res = Math.max(res, j);
        }

        return res;
    }
}
