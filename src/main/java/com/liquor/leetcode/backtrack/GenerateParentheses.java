package com.liquor.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * <p>
 * 现在有 2n 个位置，每个位置可以放置字符 ( 或者 )，组成的所有括号组合中，有多少个是合法的？
 * <p>
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParentheses {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(n, n, new StringBuilder());
        return res;
    }


    void backtrack(int left, int right, StringBuilder track) {
        // 若左括号剩下的多，说明不合法
        if (left > right) {
            return;
        }
        // 数量小于 0 肯定是不合法的
        if (left < 0 || right < 0) {
            return;
        }
        // 当所有括号都恰好用完时，得到一个合法的括号组合
        if (left == 0 && right == 0) {
            res.add(track.toString());
            return;
        }

        // 尝试放一个左括号
        track.append('('); // 选择
        backtrack(left - 1, right, track);
        track.deleteCharAt(track.length() - 1); // 撤消选择

        // 尝试放一个右括号
        track.append(')'); // 选择
        backtrack(left, right - 1, track);
        track.deleteCharAt(track.length() - 1); // 撤消选择
    }


}
