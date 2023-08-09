package com.liquor.leetcode.backtrack;

import java.util.*;

/**
 * 子集2
 * https://leetcode.cn/problems/subsets-ii/
 * <p>
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */
public class Subsets_ii {

    static List<List<Integer>> result = new ArrayList<>();


    public static void main(String[] args) {
        var nums = new int[]{1, 2, 2};
        LinkedList<Integer> track = new LinkedList<>();

        // 先排序，让相同的元素挨着
        Arrays.sort(nums);
        backtrack(nums, track, 0);
        System.out.println(result);
    }

    static void backtrack(int[] nums, LinkedList<Integer> track, int index) {
        // 只需要把节点集合加进去就好
        result.add(new LinkedList<>(track));

        // 从 index 开始，保持选中子集的相对顺序，防止出现重复子集
        for (int i = index; i < nums.length; i++) {
            // 如果元素和前面相同，就跳过，只处理第一个相同的数字，需要进行剪枝
            if (i > index &&  nums[i] == nums[i - 1]) {
                continue;
            }
            // 做出选择
            track.addLast(nums[i]);
            // 递归下一层
            backtrack(nums, track, i + 1);
            // 撤消选择
            track.removeLast();
        }
    }
}
