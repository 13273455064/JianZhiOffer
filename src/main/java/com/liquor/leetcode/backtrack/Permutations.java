package com.liquor.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 * https://leetcode.cn/problems/permutations/
 */
public class Permutations {

    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        var nums = new int[]{1, 2, 3};
        permute(nums);
        System.out.println(result);
    }

    static List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new LinkedList<>());
        return result;
    }

    static void backtrack(int[] nums, boolean[] used, LinkedList<Integer> track) {
        // 结束条件，选择了所有的数字之后，就结束
        if (track.size() == nums.length) {
            result.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 选择过的数字就跳过
            if (used[i]) {
                continue;
            }
            track.add(nums[i]);
            used[i] = true;
            // 进入下一层选择
            backtrack(nums, used, track);
            // 撤消选择
            track.removeLast();
            used[i] = false;
        }
    }
}
