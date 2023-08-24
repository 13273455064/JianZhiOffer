package com.liquor.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContainerWithMostWaterTest {

    @Test
    void maxArea() {
        var height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        var res = new ContainerWithMostWater().maxArea(height);
        Assertions.assertEquals(49, res);
    }
}