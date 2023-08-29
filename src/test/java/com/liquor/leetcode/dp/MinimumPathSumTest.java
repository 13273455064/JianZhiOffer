package com.liquor.leetcode.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinimumPathSumTest {

    @Test
    void minPathSum() {
        var num1 = new int[]{1, 3, 1};
        var num2 = new int[]{1, 5, 1};
        var num3 = new int[]{4, 2, 1};
        var grid = new int[][]{num1, num2, num3};
        var actual = new MinimumPathSum().minPathSum(grid);
        Assertions.assertEquals(7, actual);

    }
}