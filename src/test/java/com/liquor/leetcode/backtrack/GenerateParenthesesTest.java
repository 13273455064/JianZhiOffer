package com.liquor.leetcode.backtrack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class GenerateParenthesesTest {

    @Test
    void generateParenthesis() {
        var res = new GenerateParentheses().generateParenthesis(3);
        var except = List.of("((()))", "(()())", "(())()", "()(())", "()()()");
        Assertions.assertEquals(except, res);
    }
}