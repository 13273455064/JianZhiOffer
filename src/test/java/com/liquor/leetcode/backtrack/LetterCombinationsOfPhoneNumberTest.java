package com.liquor.leetcode.backtrack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class LetterCombinationsOfPhoneNumberTest {

    @Test
    void letterCombinations() {
        var digits = "23";
        var res = new LetterCombinationsOfPhoneNumber().letterCombinations(digits);
        var except = List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        Assertions.assertEquals(except, res);
    }
}