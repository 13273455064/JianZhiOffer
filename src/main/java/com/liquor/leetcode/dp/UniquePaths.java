package com.liquor.leetcode.dp;

/**
 * 不同路径
 * <p>
 * https://leetcode.cn/problems/unique-paths/
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        if (m == 0 && n == 0) {
            return 0;
        }

        return dp(m - 1, n - 1, new int[m][n]);
    }

    private int dp(int x, int y, int[][] memo) {
        // base case
        if (x == 0 && y == 0) {
            return 1;
        }

        // 防止越界
        if (x < 0 || y < 0) {
            return 0;
        }

        //备忘录
        if (memo[x][y] > 0) {
            return memo[x][y];
        }

        // 由于只能向下和向右走， x y 位置的路径数等于 左侧格子的路径数 + 上侧格子的路径数
        memo[x][y] = dp(x - 1, y, memo) + dp(x, y - 1, memo);
        return memo[x][y];
    }
}
