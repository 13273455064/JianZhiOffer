package com.liquor.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 基本计算器
 * <p>
 * https://leetcode.cn/problems/basic-calculator/
 */
public class Calculator {


    public static void main(String[] args) {
        var s = "2 - 3 * (4 + 5) + 1";
        System.out.println(calculate(s));
    }

    static int calculate(String s) {
        var queue = new LinkedList<Character>();
        for (char c : s.toCharArray()) {
            queue.add(c);
        }

        return helper(queue);
    }

    static int helper(Queue<Character> queue) {
        var stack = new Stack<Integer>();

        // 第一个数字初始化为 +
        var sign = '+';
        var num = 0;

        while (!queue.isEmpty()) {
            var c = queue.poll();
            // 是数字，就转为数字
            if (Character.isDigit(c)) {
                num = 10 * num + Character.getNumericValue(c);
            }
            // 遇到左括号，就开启递归
            if (c == '(') {
                num = helper(queue);
            }
            // 不是数字，说明是符号, 把符号前面的数字入栈
            if ((!Character.isDigit(c) && c != ' ') || queue.isEmpty()) {
                int preNum;
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        preNum = stack.pop();
                        stack.push(preNum * num);
                        break;
                    case '/':
                        preNum = stack.pop();
                        stack.push(preNum / num);
                        break;
                }

                sign = c;
                num = 0;
            }

            // 遇到右括号就结束递归
            if (c == ')') {
                break;
            }
        }

        var result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;

    }
}
