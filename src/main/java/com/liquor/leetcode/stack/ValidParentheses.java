package com.liquor.leetcode.stack;

import java.util.Stack;

/**
 * 有效的括号
 * <p>
 * https://leetcode.cn/problems/valid-parentheses/
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        var stack = new Stack<Character>();

        for (Character ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty() && leftOf(ch) == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    Character leftOf(Character ch) {
        switch (ch) {
            case ')':
                return '(';
            case '}':
                return '{';
            case ']':
                return '[';
            default:
                return null;
        }
    }
}
