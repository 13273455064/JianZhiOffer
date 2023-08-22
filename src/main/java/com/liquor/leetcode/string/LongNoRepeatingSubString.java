package com.liquor.leetcode.string;

import java.util.HashMap;

/**
 * 最长不重复子字符串
 * <p>
 * https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 */
public class LongNoRepeatingSubString {

    int res;

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        var map = new HashMap<Character, Integer>();
        var left = 0;
        var right = 0;
        while (left <= right && right <= s.length() - 1) {
            var c = s.charAt(right);

            map.put(c, map.getOrDefault(c, 0) + 1);

            // 扩大窗口
            right++;

            // 缩小窗口
            while (map.get(c) > 1 && left < right) {
                var d = s.charAt(left);
                left++;
                map.put(d, map.get(d) - 1);
            }

            res = Math.max(res, right - left);

        }

        return res;
    }
}
