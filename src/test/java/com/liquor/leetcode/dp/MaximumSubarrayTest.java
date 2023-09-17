package com.liquor.leetcode.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaximumSubarrayTest {

    @Test
    void maxSubArray() {
        var nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        var maxSubArray = new MaximumSubarray().maxSubArray(nums);
        Assertions.assertEquals(6, maxSubArray);
    }
}