package com.liquor.leetcode.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongNoRepeatingSubStringTest {

    @Test
    void lengthOfLongestSubstring() {
        var test = new LongNoRepeatingSubString();
        int result = test.lengthOfLongestSubstring("abcabcbb");
        assertEquals(result, 3);
    }
}