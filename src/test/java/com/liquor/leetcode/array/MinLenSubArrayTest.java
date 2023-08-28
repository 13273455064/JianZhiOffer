package com.liquor.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinLenSubArrayTest {

    @Test
    void minSubArrayLen() {
        var nums = new int[]{2, 3, 1, 2, 4, 3};
        var result = new MinLenSubArray().minSubArrayLen(7, nums);
        Assertions.assertEquals(2, result);
    }

    @Test
    void testMinSubArrayLen() {
        var nums = new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8};
        var result = new MinLenSubArray().minSubArrayLen(15, nums);
        Assertions.assertEquals(2, result);
    }
}