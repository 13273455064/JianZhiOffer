package com.liquor.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductOfArrayExceptSelfTest {

    @Test
    void productExceptSelf() {
        var arr = new int[]{1, 2, 3, 4};
        var result = new ProductOfArrayExceptSelf().productExceptSelf(arr);
        Assertions.assertArrayEquals(new int[]{24, 12, 8, 6}, result);
    }
}