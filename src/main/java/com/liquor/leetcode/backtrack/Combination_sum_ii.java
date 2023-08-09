package com.liquor.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和2
 * https://leetcode.cn/problems/combination-sum-ii/
 * <p>
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * <p>
 * 注意：解集不能包含重复的组合。
 */
public class Combination_sum_ii {

    static List<List<Integer>> result = new ArrayList<>();
    static int sum = 0;


    public static void main(String[] args) {
        var candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        var target = 8;
        LinkedList<Integer> track = new LinkedList<>();

        // 先排序，让相同的元素挨着
        Arrays.sort(candidates);
        backtrack(candidates, track, 0, target);
        System.out.println(result);
    }

    static void backtrack(int[] candidates, LinkedList<Integer> track, int index, int target) {
        if (sum == target) {
            result.add(new LinkedList<>(track));
            return;
        }
        if (sum > target) {
            return;
        }

        // 从 index 开始，保持选中子集的相对顺序，防止出现重复子集
        for (int i = index; i < candidates.length; i++) {
            // 如果元素和前面相同，就跳过，只处理第一个相同的数字，需要进行剪枝
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // 做出选择
            track.addLast(candidates[i]);
            sum += candidates[i];
            //sum  = track.stream().mapToInt(Integer::intValue).sum();
            // 递归下一层
            backtrack(candidates, track, i + 1, target);
            // 撤消选择
            track.removeLast();
            sum -= candidates[i];
            //sum  = track.stream().mapToInt(Integer::intValue).sum();
        }
    }
}
