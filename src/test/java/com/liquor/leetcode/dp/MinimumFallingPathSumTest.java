package com.liquor.leetcode.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinimumFallingPathSumTest {

    @Test
    void minFallingPathSum() {
        var arr = new int[]{2, 1, 3};
        var arr2 = new int[]{6, 5, 4};
        var arr3 = new int[]{7, 8, 9};
        var matrix = new int[][]{arr, arr2, arr3};
        var test = new MinimumFallingPathSum();
        int res = test.minFallingPathSum(matrix);
        Assertions.assertEquals(13, res);
    }
}