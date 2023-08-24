package com.liquor.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 * <p>
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfPhoneNumber {

    static final String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return List.of();
        }

        backtrack(digits, 0, new StringBuilder());

        return res;
    }

    private void backtrack(String digits, int start, StringBuilder sb) {
        //递归结束条件，sb 里面的字母长度和 digits 相同，也就是每个按键都摁了一遍
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }

        for (int i = start; i < digits.length(); i++) {
            var d = digits.charAt(i) - '0';
            for (Character ch : map[d].toCharArray()) {
                // 做选择
                sb.append(ch);
                // 进入下一级
                backtrack(digits, i + 1, sb);
                // 撤销选择, 删除最后一个字符
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }
}
