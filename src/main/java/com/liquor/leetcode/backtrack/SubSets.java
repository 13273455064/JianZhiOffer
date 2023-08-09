package com.liquor.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 求集合子不重复子集
 * <p>
 * https://leetcode.cn/problems/subsets/
 * <p>
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 回溯法
 */
public class SubSets {

    static List<List<Integer>> result = new ArrayList<>();


    public static void main(String[] args) {
        var nums = new int[]{1, 2, 3};
        LinkedList<Integer> track = new LinkedList<>();

        backtrack(nums, track, 0);
        System.out.println(result);
    }

    static void backtrack(int[] nums, LinkedList<Integer> track, int index) {
        // 只需要把节点集合加进去就好
        result.add(new LinkedList<>(track));

        // 从 index 开始，保持选中子集的相对顺序，放置出现重复子集
        for (int i = index; i < nums.length; i++) {
            // 做出选择
            track.addLast(nums[i]);
            // 递归下一层
            backtrack(nums, track, i + 1);
            // 撤消选择
            track.removeLast();
        }
    }
}
