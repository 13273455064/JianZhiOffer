package com.liquor.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Sum3Test {

    @Test
    void threeSum() {
        var nums = new int[]{-1, 0, 1, 2, -1, -4};

        var res = new Sum3().threeSum(nums);

        var except = List.of(List.of(-1, 2, -1), List.of(0, 1, -1));
        Assertions.assertEquals(except, res);
    }
}