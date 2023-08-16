package com.liquor.leetcode.string;

/**
 * 最长回文子字符串
 * <p>
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 */
public class LongPalindromicSubString {

    public static void main(String[] args) {
        var str = "babad";

        System.out.println(longPalindromic(str));

    }

    static String longPalindromic(String str) {
        if (str == null || str.isEmpty() || str.length() == 1) {
            return str;
        }
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            var s1 = find(str, i, i);
            var s2 = find(str, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }

        return res;
    }

    /**
     * 从中心向两边扩散，寻找回文串
     */
    static String find(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }

        return str.substring(left + 1, right);
    }
}
