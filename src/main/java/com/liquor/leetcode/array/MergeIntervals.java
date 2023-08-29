package com.liquor.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 合并区间
 * <p>
 * https://leetcode.cn/problems/merge-intervals/
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        // 只有一个数组，不需要合并
        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        LinkedList<int[]> result = new LinkedList<>();
        result.addFirst(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            var last = result.getLast();
            var cur = intervals[i];

            if (last[1] >= cur[0]) {
                // 由于是按照 start 排好序的，有交叉的情况只需要改变 last 的 end 元素即可，看作一个新数组
                last[1] = Math.max(last[1], cur[1]);
            } else {
                result.addLast(cur);
            }
        }

        return result.toArray(new int[0][0]);
    }

}
