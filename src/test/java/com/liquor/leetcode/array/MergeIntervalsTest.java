package com.liquor.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MergeIntervalsTest {

    @Test
    void merge() {
        var int1 = new int[]{1, 3};
        var int2 = new int[]{2, 6};
        var int3 = new int[]{8, 10};
        var int4 = new int[]{15, 18};
        var intervals = new int[][]{int1, int2, int3, int4};
        var result = new MergeIntervals().merge(intervals);
        var except = new int[][]{new int[]{1, 6}, int3, int4};
        Assertions.assertArrayEquals(except, result);
    }
}