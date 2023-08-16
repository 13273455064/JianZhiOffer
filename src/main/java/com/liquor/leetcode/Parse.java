package com.liquor.leetcode;

import java.util.Map;
import java.util.Stack;

public class Parse {

    public static void main(String[] args) {
        var values = Map.of("ONE", "1", "TWO", "2");
        var tmpStr = "is ${ONE},${ and ${ TWO }";


        System.out.println(parse(tmpStr, values));
    }

    static String parse(String tmpStr, Map<String, String> values) {
        var position = 0;

        var stack = new Stack<Integer>();

        var len = tmpStr.length();

        var sb = new StringBuilder();

        while (position < len - 1) {
            var c = tmpStr.charAt(position);
            // 找到第一个 $
            if ('$' == c) {

                // 然后找右括号
                var r = position;
                while (r < len && tmpStr.charAt(r) != '}') {
                    //找右括号的过程中发现了左括号就入栈
                    if (tmpStr.charAt(r) == '{') {
                        stack.push(r);
                    }
                    r++;
                }

                // 找不到右括号
                if (r == len - 1 && tmpStr.charAt(r) != '}') {
                    sb.append(tmpStr, position, len);
                    return sb.toString();
                } else {
                    // 找到了右括号，但是没有左括号
                    if (stack.isEmpty()) {
                        sb.append(tmpStr, position, len - 1);
                        return sb.toString();
                    } else {
                        // 左指针改变成左括号在的位置
                        var leftPosition = stack.pop();
                        // 如果栈不为空，说明存在不成对的左括号
                        if (!stack.isEmpty()) {
                            sb.append(tmpStr, position, leftPosition - 1);
                            stack.clear();
                        }

                        //左括号和右括号都找到了，开始找 key
                        var key = tmpStr.substring(leftPosition + 1, r).trim();
                        if (values.containsKey(key)) {
                            sb.append(values.get(key));
                        } else {
                            sb.append(tmpStr, position, r + 1);
                        }
                    }
                }

                // 从最右侧开始搜索
                position = r + 1;

            } else {
                sb.append(c);
                position++;
            }
        }

        return sb.toString();
    }

}
