package com.liquor.leetcode.dp;

import java.util.Arrays;

/**
 * 下降路径最小和
 * <p>
 * https://leetcode.cn/problems/minimum-falling-path-sum/description/
 */
public class MinimumFallingPathSum {

    int[][] memo;

    public int minFallingPathSum(int[][] matrix) {
        var n = matrix.length;
        //  备忘录
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], 66666);
        }

        int res = Integer.MAX_VALUE;
        // 重点可能在最后一行的任意一列
        for (int col = 0; col < n; col++) {
            res = Math.min(res, dp(matrix, n - 1, col));
        }

        return res;
    }


    private int dp(int[][] matrix, int row, int col) {
        var n = matrix.length;
        // 防止越界
        if (row >= n || col >= matrix[0].length || row < 0 || col < 0) {
            return 99999;
        }

        // 确定 base case
        if (row == 0) {
            return matrix[0][col];
        }

        if (memo[row][col] != 66666) {
            return memo[row][col];
        }

        memo[row][col] = matrix[row][col] + Math.min(dp(matrix, row - 1, col),
                Math.min(dp(matrix, row - 1, col - 1),
                        dp(matrix, row - 1, col + 1)));

        return memo[row][col];
    }
}
