package com.liquor.leetcode.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidParenthesesTest {

    @Test
    void isValid() {
        var s = "()[]{}";
        var actual = new ValidParentheses().isValid(s);
        Assertions.assertTrue(actual);
    }

    @Test
    void isValid2() {
        var s = "]";
        var actual = new ValidParentheses().isValid(s);
        Assertions.assertFalse(actual);
    }
}