package com.liquor.leetcode.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestValidParenthesesTest {

    @Test
    void longestValidParentheses() {
        var s = ")()())";
        var res = new LongestValidParentheses().longestValidParentheses(s);
        Assertions.assertEquals(4, res);
    }
}