package com.liquor.leetcode.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestIncreasingSubsequenceTest {

    @Test
    void lengthOfLIS() {
        var test = new LongestIncreasingSubsequence();
        var nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int res = test.lengthOfLIS(nums);
        Assertions.assertEquals(res, 4);
    }
}