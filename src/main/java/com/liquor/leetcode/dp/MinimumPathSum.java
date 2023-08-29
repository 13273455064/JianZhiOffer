package com.liquor.leetcode.dp;

import java.util.Arrays;

/**
 * 最小路径和
 * <p>
 * https://leetcode.cn/problems/minimum-path-sum/
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        // 创建并初始化备忘录
        // memo[x][y] 表示在 x, y 位置的最小路径和
        var memo = new int[grid.length][grid[0].length];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }


        return dp(grid, grid.length - 1, grid[0].length - 1, memo);

    }


    private int dp(int[][] grid, int x, int y, int[][] memo) {
        // base case
        if (x == 0 && y == 0) {
            memo[x][y] = grid[x][y];
            return grid[x][y];
        }

        // 防止越界
        if (x < 0 || y < 0) {
            return Integer.MAX_VALUE;
        }

        // 查看备忘录
        if (memo[x][y] != -1) {
            return memo[x][y];
        }

        // x, y 最小的路径和等于 上面和左面 最小路径和中的较小值 + grid[x][y] 的值
        memo[x][y] = Math.min(
                dp(grid, x - 1, y, memo),
                dp(grid, x, y - 1, memo)
        ) + grid[x][y];

        return memo[x][y];

    }
}
