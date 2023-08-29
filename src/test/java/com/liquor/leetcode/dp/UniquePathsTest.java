package com.liquor.leetcode.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UniquePathsTest {

    @Test
    void uniquePaths() {
        var actual = new UniquePaths().uniquePaths(3, 7);
        Assertions.assertEquals(28, actual);
    }
}