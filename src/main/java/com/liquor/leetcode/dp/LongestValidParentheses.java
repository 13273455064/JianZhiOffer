package com.liquor.leetcode.dp;

import java.util.Stack;

/**
 * 最长有效括号
 * <p>
 * https://leetcode.cn/problems/longest-valid-parentheses/description/
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        var stack = new Stack<Integer>();
        // dp[i] 表示以 i - 1 为结尾的有效括号字串的长度
        var dp = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            // 只有左右括号
            if (s.charAt(i) == '(') {
                stack.push(i);
                dp[i + 1] = 0;
            } else {
                if (!stack.isEmpty()) {
                    var leftIndex = stack.pop();
                    // 左右括号之前的长度 + 左括号时最长有效括号长度 + 右括号自身的长度 1
                    var len = i - leftIndex + dp[leftIndex] + 1;
                    dp[i + 1] = len;
                } else {
                    dp[i + 1] = 0;
                }
            }
        }
        var maxLen = 0;
        for (int len : dp) {
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}
